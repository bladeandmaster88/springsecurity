package com.icss.controller;

import com.icss.service.SystemSetService;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private SystemSetService systemSetService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        return "page/login";
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
        return "system/login";
    }
}
