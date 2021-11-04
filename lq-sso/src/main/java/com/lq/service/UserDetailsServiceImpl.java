package com.lq.service;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Validator;
import com.google.common.collect.Sets;
import com.lq.common.enums.UserStatus;
import com.lq.domain.LoginUser;
import com.lq.system.entity.SysUser;
import com.lq.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户名和密码验证
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Resource
    private ISysUserService iSysUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = iSysUserService.lambdaQuery().eq(SysUser::getUserName, userName).one();
        Assert.notNull(sysUser,"该用户名不存在！");
        Validator.validateNotEqual(UserStatus.DISABLE.getCode(), sysUser.getDelFlag(), "该账号已停用！");
        return createLoginUser(sysUser);
    }

    private UserDetails createLoginUser(SysUser user)
    {
        Set<String> permissions = Sets.newHashSet("admin");
        return new LoginUser(user.getUserId(), user.getDeptId(), user,permissions );
    }

}
