package com.lq.web.controller;


import com.lq.common.core.domain.ResponseEntity;
import com.lq.system.entity.Dict;
import com.lq.system.service.IDictService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
@RestController
@CrossOrigin
@RequestMapping("/dict")
public class DictController {
    @Resource
    IDictService dictService;

    @GetMapping("/listByParentId/{parentId}")
    public ResponseEntity listByParentId(@PathVariable Long parentId) {
        List<Dict> list = dictService.listByParentId(parentId);
        return ResponseEntity.success(list);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Dict dict = dictService.getById(id);
        return ResponseEntity.success(dict);
    }

    @PostMapping("/saveOrUpdateDict")
    public ResponseEntity saveOrUpdateDict(@RequestBody Dict dict) {

        if (dictService.saveOrUpdate(dict)) {
            return ResponseEntity.success("操作成功！");
        }
        return ResponseEntity.error("操作失败,请稍后重试！");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (dictService.removeById(id)) {
            return ResponseEntity.success("删除成功！");
        }
        return ResponseEntity.error("删除失败！");
    }

}

