package com.lq.service;

import com.lq.domain.LoginUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Service
public class SysLoginService {
    @Resource
   private AuthenticationManager authenticationManager;

    @Resource
   private TokenService tokenService;

    private String login(String username, String password) {
        // 获取认证对象
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String token = tokenService.createToken(loginUser);
        return token;
    }
}
