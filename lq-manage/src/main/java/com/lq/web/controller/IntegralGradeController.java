package com.lq.web.controller;


import com.lq.common.core.domain.ResponseEntity;
import com.lq.system.entity.IntegralGrade;
import com.lq.system.service.IIntegralGradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
@RestController
@RequestMapping("/integralGrade")
public class IntegralGradeController {
    @Resource
    private IIntegralGradeService iIntegralGradeService;

    @GetMapping("/list")
    public ResponseEntity select() {
        List<IntegralGrade> list = iIntegralGradeService.list();
        return ResponseEntity.success(list);
    }

    @PostMapping("/save")
    public ResponseEntity save(@Valid IntegralGrade integralGrade) {
        boolean save = iIntegralGradeService.save(integralGrade);
        if (save) {
          return   ResponseEntity.success();
        }
        return ResponseEntity.error();
    }

}

