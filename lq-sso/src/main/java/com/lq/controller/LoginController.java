package com.lq.controller;

import com.lq.common.core.domain.ResponseEntity;
import com.lq.domain.LoginUser;
import com.lq.domain.vo.LoginVO;
import com.lq.service.SysLoginService;
import com.lq.system.entity.SysUser;
import com.lq.utils.SecurityUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登录
 *
 * @author LQ
 */
@RestController
//@CrossOrigin
public class LoginController {

    @Resource
    private SysLoginService sysLoginService;

    /**
     * 登录认证
     * @param loginVO 登录对象
     * @return token
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginVO loginVO) {
        String token = sysLoginService.login(loginVO.getUsername(), loginVO.getPassword());
        ResponseEntity response = ResponseEntity.success();
        response.put("token",token);
        return response;
    }

    @GetMapping("/info")
    public ResponseEntity getInfo(){
        SysUser sysUser = SecurityUtils.getLoginUser().getUser();
        sysUser.setRoles("admin");
        sysUser.setAvatar("");
        return ResponseEntity.success(sysUser);
    }

    @PostMapping("/test")
    public ResponseEntity test() {

//        String token = sysLoginService.login(loginVO.getUsername(), loginVO.getPassword());
//        ResponseEntity response = ResponseEntity.success();
//        response.put("token",token);
        return ResponseEntity.success("test");
    }
}
