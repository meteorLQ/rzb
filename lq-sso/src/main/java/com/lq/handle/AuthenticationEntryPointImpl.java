package com.lq.handle;

import com.lq.common.constant.HttpStatus;
import com.lq.common.core.domain.ResponseEntity;
import com.lq.common.utils.JsonUtils;
import com.lq.common.utils.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        int code = HttpStatus.UNAUTHORIZED;
        ServletUtils.renderString(httpServletResponse, JsonUtils.toJson(ResponseEntity.error(code,"未授权，请登录")));
    }
}
