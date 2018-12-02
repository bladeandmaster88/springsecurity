package com.icss.controller;

import com.icss.service.SystemSetService;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanMetadataAttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.http.HttpSecurityBeanDefinitionParser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.DelegatingFilterProxy;

@Controller
@RequestMapping("/system")
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private SystemSetService systemSetService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        return "login";
    }

//    @RequestMapping("/doLogin")
//    @ResponseBody
//    public Forward doLogin(HttpServletRequest request, String username, String password) {
//        Forward forward = new Forward();
//        Map<String, String> conditions = new HashMap();
//        conditions.put("password", MD5Util.EncryptStr(password));
//        conditions.put("username", username);
//        UserInfo icssUserInfo = this.systemSetService.isValidUser(conditions);
//        if (icssUserInfo != null) {
//            request.getSession().setAttribute("user", icssUserInfo);
//            forward.setSuccess(true);
//        } else {
//            forward.setSuccess(false);
//        }
//        return forward;
//    }

    @RequestMapping("/loginOut")
    public String logOut(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "login";
    }
}
