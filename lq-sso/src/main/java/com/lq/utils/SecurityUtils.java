package com.lq.utils;

import com.lq.common.constant.HttpStatus;
import com.lq.common.exception.ServiceException;
import com.lq.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全工具类
 */
public class SecurityUtils {

    /**
     * 加密密码
     * @param password
     * @return
     */
    public static String encodePassword(String password){
        String encode = new BCryptPasswordEncoder().encode(password);
        return encode;
    }

    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser()
    {
        try
        {
            return (LoginUser) getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户信息异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static void main(String[] args) {
        System.out.println("encodePassword = " + encodePassword("123456"));
    }
}
