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

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/listByParentId/{parentId}")
    public ResponseEntity listByParentId(@PathVariable Long parentId){
        List<Dict> list= dictService.listByParentId(parentId);
        return  ResponseEntity.success(list);
    }
    @GetMapping("/redisTest")
    public ResponseEntity redisTest(){
        Dict dict = dictService.getById(1);
        redisTemplate.opsForValue().set("dict",dict);
        return  ResponseEntity.success();
    }
    @GetMapping("/redisGet")
    public ResponseEntity redisGet(){

        Dict dict = (Dict) redisTemplate.opsForValue().get("dict");
        return  ResponseEntity.success(dict);
    }
}

