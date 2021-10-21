package com.lq.system.service;

import com.lq.system.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
public interface IDictService extends IService<Dict> {

    List<Dict> listByParentId(Long parentId);
}
