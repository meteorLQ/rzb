package com.lq.service;

import cn.hutool.core.util.RandomUtil;
import com.lq.domain.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {
    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser) {
        //String token = IdUtils.fastUUID();
        //loginUser.setToken(token);
        //setUserAgent(loginUser);
        // refreshToken(loginUser);
        String id = RandomUtil.randomNumbers(6);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userID", id);
        return createToken(claims);
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }

    /**
     * 解析token
     *
     * @param token token字符串
     * @return
     */
    private Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * 根据token获取用户标识
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

}
