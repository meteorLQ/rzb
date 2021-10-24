package com.lq.system.service.impl;

import com.lq.system.config.MyMetaObjectHandler;
import com.lq.system.entity.Dict;
import com.lq.system.mapper.DictMapper;
import com.lq.system.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

    private static final Logger log = LoggerFactory.getLogger(DictServiceImpl.class);

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public List<Dict> listByParentId(Long parentId) {
        // 首先查询redis中是否存在数据列表
        try {
            log.info("redis中读取");
            List<Dict> dictList = (List<Dict>) redisTemplate.opsForValue().get("rzb:dictList" + parentId);
            if (CollectionUtils.isNotEmpty(dictList)) {
                return dictList;
            }
        } catch (Exception e) {
            log.error("redis读取异常:", ExceptionUtils.getStackTrace(e));
        }
        //如果存在则从redis中直接返回数据列表

        // 如果不存在则查询数据库
        log.info("读取数据库中字典数据");
        List<Dict> dicts = this.lambdaQuery().eq(Dict::getParentId, parentId).list();
        dicts.forEach(dict -> {
            Boolean hasChildren = isHasChildren(dict.getId());
            if (hasChildren) {
                dict.setHasChildren(Boolean.TRUE);
            }
        });
        try {
            redisTemplate.opsForValue().set("rzb:dictList" + parentId, dicts, 5, TimeUnit.MINUTES);
            log.info("字典数据存入redis中");
        } catch (Exception e) {
            log.error("redis读取异常:", ExceptionUtils.getStackTrace(e));
        }

        return dicts;
    }

    @Override
    public boolean save(Dict dict) {
        boolean save = super.save(dict);
        if (save) {
            try {

                Boolean flag = redisTemplate.delete("rzb:dictList" + dict.getParentId());
                if (flag) {
                    return Boolean.TRUE;
                }
            } catch (Exception e) {
                log.error("缓存删除失败:key{}", "rzb:dictList" + dict.getParentId(), e);
            }
        }
        return Boolean.FALSE;
    }

    public Boolean isHasChildren(Long id) {
        Long count = this.lambdaQuery().eq(Dict::getParentId, id).count();
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
