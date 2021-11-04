package com.lq.utils;

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

    public static void main(String[] args) {
        System.out.println("encodePassword = " + encodePassword("123456"));
    }
}
