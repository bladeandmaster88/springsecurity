package com.icss.controller;

import com.icss.utils.Forward;
import com.icss.security.SpringSecurityUtils;
import com.icss.model.MenuModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class MainController {
    private Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping
    public String index(HttpServletRequest request) {
        return "page/main";
    }

    @RequestMapping("/getMenu")
    @ResponseBody
    public Forward getMenu(HttpServletRequest request) {
        Forward forward = new Forward();
        try {
            Set<MenuModel> menuSet = SpringSecurityUtils.getCurrentMenuList();
            List<MenuModel> menuList = new ArrayList();
            menuList.addAll(menuSet);
            forward.setList(menuList);
            forward.setSuccess(true);
        } catch (Exception e) {
            forward.setSuccess(false);
        }
        return forward;
    }
}
