package com.icss.security;

import com.icss.model.UserInfo;
import com.icss.service.SystemSetService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginLogHandler implements AuthenticationSuccessHandler {

    @Autowired
    private SystemSetService systemSetService;

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        request.getSession().removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        OperatorDetails user = (OperatorDetails) SpringSecurityUtils.getCurrentUser();
        String userName = user.getUsername();
        String password = user.getPassword();
        Map<String, String> conditions = new HashMap();
        conditions.put("password", password);
        conditions.put("username", userName);
        UserInfo userInfo = systemSetService.isValidUser(conditions);
        request.getSession().setAttribute("user", userInfo);
        String interfaceUrl = request.getParameter("spring-security-redirect");
        String redirectUrl = "";
        if (StringUtils.isNotBlank(interfaceUrl)) {
            redirectUrl = request.getContextPath() + interfaceUrl;
            response.sendRedirect(redirectUrl);
        } else {
            String defaultUrl = "/main";
            redirectUrl = request.getContextPath()+defaultUrl;
            response.sendRedirect(redirectUrl);
        }
    }
}