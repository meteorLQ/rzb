package com.lq.web.controller.admin;

import com.lq.common.core.controller.BaseController;
import com.lq.common.core.domain.ResponseEntity;
import com.lq.system.service.ISysMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SysLoginController extends BaseController {

    @Resource
    ISysMenuService menuService;

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("/getRouters")
    public ResponseEntity getRouters() {

        return ResponseEntity.success();
    }
}
