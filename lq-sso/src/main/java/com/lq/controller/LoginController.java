package com.lq.controller;

import com.lq.domain.LoginUser;
import com.lq.common.core.domain.ResponseEntity;
import com.lq.service.TokenService;
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
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(LoginUser loginUser) {
      //  tokenService.createToken(loginUser);
        return ResponseEntity.success("sussexx");
    }
}
