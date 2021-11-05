package com.lq.filter;

import com.lq.common.constant.Constants;
import com.lq.common.utils.StringUtils;
import com.lq.domain.LoginUser;
import com.lq.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Resource
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
            LoginUser loginUser = tokenService.getUserByToken(token);

            // 拿到用户信息后验证用户信息与token
            if (loginUser != null) {

                // 组装authentication对象，构造参数是Principal Credentials 与 Authorities
                // 后面的拦截器里面会用到 grantedAuthorities 方法
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginUser, loginUser.getPassword(), loginUser.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // 将authentication信息放入到上下文对象中
                SecurityContextHolder.getContext().setAuthentication(authentication);

//            log.info("JWT过滤器通过校验请求头token自动登录成功, user : {}", userDetails.getUsername());
            }
        }


        filterChain.doFilter(request, response);
    }
}
