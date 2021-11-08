package com.lq.service;

import cn.hutool.core.util.RandomUtil;
import com.lq.domain.LoginUser;
import com.sun.tools.javac.Main;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class TokenService {
    // 令牌秘钥
//    @Value("${token.secret}")
    private String secret="abcdefghijklmnopqrstuvwxyz";

    @Resource
    RedisTemplate redisTemplate;

    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser) {
        //String token = IdUtils.fastUUID();
//        loginUser.setToken(token);
        //setUserAgent(loginUser);
        // refreshToken(loginUser);
        String id = RandomUtil.randomNumbers(6);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userID", id);
        redisTemplate.opsForValue().set(id,loginUser,30, TimeUnit.MINUTES);
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


    public LoginUser getUserByToken(String token){
        Claims claims = parseToken(token);
        String userID = (String) claims.get("userID");
        ValueOperations<String,LoginUser> valueOperations = redisTemplate.opsForValue();
        LoginUser loginUser = valueOperations.get(userID);
        return loginUser;
    }

    /**
     * 根据token获取用户标识
     *
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    public static void main(String[] args) {
        String token ="eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySUQiOiI3MTAyODcifQ.7BHf_xZvMO5iQhEAOEjN3Um-wMQtEuLlCPE9BHtaU9c4eXCLL0QQtuc627p5gYbdXinsJmzBwWR3sVxc0K0zRQ";

        TokenService tokenService = new TokenService();
        String usernameFromToken = tokenService.getUsernameFromToken(token);
        System.out.println("usernameFromToken = " + usernameFromToken);
    }
}
