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
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.SecurityNamespaceHandler;
import org.springframework.security.config.http.FormLoginBeanDefinitionParser;
import org.springframework.security.config.http.HttpSecurityBeanDefinitionParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.xml.DomUtils;
import org.springframework.web.filter.DelegatingFilterProxy;

@Component
public class LoginLogHandler implements AuthenticationSuccessHandler {

    @Autowired
    private SystemSetService systemSetService;
    //ScannedGenericBeanDefinition
    //BeanMetadataAttributeAccessor
    //AbstractBeanDefinition
    LoginUrlAuthenticationEntryPoint p;
    //ExceptionTranslationFilter
    FilterSecurityInterceptor filterSecurityInterceptor;
    FilterChainProxy filterChainProxy;
    DelegatingFilterProxy delegatingFilterProxy;

    SecurityNamespaceHandler securityNamespaceHandler;
    //HttpConfigurationBuilder httpConfigurationBuilder;
    HttpSecurityBeanDefinitionParser parser;
    FormLoginBeanDefinitionParser formLoginBeanDefinitionParser;
    DomUtils domUtils;
    BeanIds beanIds;
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        request.getSession().removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        //保存登陆成功之后的session
        OperatorDetails user = (OperatorDetails) SpringSecurityUtils.getCurrentUser();
        String userName = user.getUsername();
        String password = user.getPassword();
        Map<String, String> conditions = new HashMap();
        conditions.put("password", password);
        conditions.put("username", userName);
        UserInfo userInfo = systemSetService.isValidUser(conditions);
        request.getSession().setAttribute("user", userInfo);
        //实现页面跳转
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