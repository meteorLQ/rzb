package com.lq.web.controller;


import com.lq.system.entity.UserInfo;
import com.lq.system.service.IUserInfoService;
import com.lq.system.service.impl.UserInfoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource
    private IUserInfoService userInfoService;

    @PostMapping("/test")
    @ResponseBody
    public List<UserInfo> test(){
        List<UserInfo> list = userInfoService.list();
        return list;
    }

}

