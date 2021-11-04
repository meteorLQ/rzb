package com.lq.controller;

import com.lq.common.core.domain.ResponseEntity;
import com.lq.domain.vo.LoginVO;
import com.lq.service.SysLoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录
 *
 * @author LQ
 */
@RestController
@CrossOrigin
public class LoginController {

    @Resource
    private SysLoginService sysLoginService;

    /**
     * 登录认证
     * @param loginVO 登录对象
     * @return token
     */
    @PostMapping("/login")
    public ResponseEntity login(LoginVO loginVO) {
        String token = sysLoginService.login(loginVO.getUsername(), loginVO.getPassword());
        ResponseEntity response = ResponseEntity.success();
        response.put("token",token);
        return response;
    }

    @PostMapping("/test")
    public ResponseEntity test() {
//        String token = sysLoginService.login(loginVO.getUsername(), loginVO.getPassword());
//        ResponseEntity response = ResponseEntity.success();
//        response.put("token",token);
        return ResponseEntity.success("test");
    }
}
