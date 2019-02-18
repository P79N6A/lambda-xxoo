package com.yatop.lambda.portal.common.authentication;

import com.alibaba.fastjson.JSONObject;
import com.yatop.lambda.portal.common.domain.PortalResponse;
import com.yatop.lambda.portal.common.properties.LambdaPortalProperties;
import com.yatop.lambda.portal.common.utils.PortalUtil;
import com.yatop.lambda.portal.common.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private static final String TOKEN = "Authentication";

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        LambdaPortalProperties lambdaPortalProperties = SpringContextUtil.getBean(LambdaPortalProperties.class);
        String[] anonUrl = StringUtils.splitByWholeSeparatorPreserveAllTokens(lambdaPortalProperties.getShiro().getAnonUrl(), ",");
        for (String u : anonUrl) {
            if (pathMatcher.match(u, httpServletRequest.getRequestURI()))
                return true;
        }

        if (isLoginAttempt(request, response)) {
            try {
                return this.executeLogin(request, response);
            } catch (Exception e) {
                this.response401(request, response, e.getMessage());
                return false;
            }
        }

        this.response401(request, response, "请先登录");
        return false;
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(TOKEN);
        return token != null;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(TOKEN);
        JWTToken jwtToken = new JWTToken(PortalUtil.decryptToken(token));
        getSubject(request, response).login(jwtToken);
        return true;
    }

    /**
     * 无需转发，直接返回Response信息
     */
    private void response401(ServletRequest req, ServletResponse resp, String msg) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = httpServletResponse.getWriter();
            PortalResponse portalResponse = new PortalResponse().message(msg);
            out.append(JSONObject.toJSONString(portalResponse));
        } catch (IOException e) {
            log.error("发生IO异常错误:" + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个 option请求，这里我们给 option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
