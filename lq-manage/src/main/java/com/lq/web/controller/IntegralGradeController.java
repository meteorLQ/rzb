package com.lq.web.controller;


import com.lq.common.core.controller.BaseController;
import com.lq.common.core.domain.ResponseEntity;
import com.lq.system.entity.IntegralGrade;
import com.lq.system.service.IIntegralGradeService;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@RequestMapping("/core/integralGrade")
public class IntegralGradeController extends BaseController {
    @Resource
    private IIntegralGradeService iIntegralGradeService;

    @GetMapping("/list")
    public ResponseEntity select() {
        List<IntegralGrade> list = iIntegralGradeService.list();
        return ResponseEntity.success(list);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        IntegralGrade integralGrade = iIntegralGradeService.getById(id);
        return ResponseEntity.success(integralGrade);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (iIntegralGradeService.removeById(id)) {
            return ResponseEntity.success("删除成功！");
        }
        return ResponseEntity.error("删除失败！");
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody @Valid IntegralGrade integralGrade) {
        if (null != integralGrade.getId()) {
            iIntegralGradeService.updateById(integralGrade);
        } else {
            iIntegralGradeService.save(integralGrade);
        }

        return ResponseEntity.success();
    }

}

