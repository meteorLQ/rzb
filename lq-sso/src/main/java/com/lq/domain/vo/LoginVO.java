package com.lq.domain.vo;

/**
 * 登录对象
 *
 * @author LQ
 */
public class LoginVO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
