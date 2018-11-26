package com.icss.security;

import com.icss.model.MenuModel;
import com.icss.service.SystemSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Component
public class SpringSecurityUtils {
    @Autowired
    private SystemSetService systemSetService;
    private static SpringSecurityUtils springSecurityUtils;

    @PostConstruct
    public void unit() {
        springSecurityUtils = this;
        springSecurityUtils.systemSetService = this.systemSetService;
    }

    public static <T extends User> T getCurrentUser() {
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if ((principal instanceof User)) {
                return (T) principal;
            }
        }
        return null;
    }

    private static Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null) {
            return context.getAuthentication();
        }
        return null;
    }

    /**
     *
     * 获取当前角色菜单集合
     */
    public static Set<MenuModel> getCurrentMenuList(){

        Collection<GrantedAuthority> roles=SpringSecurityUtils.getCurrentRoles();
        Iterator<GrantedAuthority> ite=roles.iterator();
        Set<MenuModel> menuSet=new HashSet<MenuModel>();
        while (ite.hasNext()) {
            GrantedAuthority ga=ite.next();
            MenuModel model=new MenuModel();
            model.setName(ga.getAuthority());
            List<MenuModel> mList=springSecurityUtils.systemSetService.getMenuListByMenuModel(model);
            for(MenuModel mm :mList){
                menuSet.add(mm);
            }

        }
        return menuSet;
    }

    public static Collection<GrantedAuthority> getCurrentRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<GrantedAuthority> ga = authentication.getAuthorities();
        return ga;
    }


    public static void reloadRoleMenu(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            ServletContext context = session.getServletContext();
            WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            DbSecurityInfo dbSecurityInfo = (DbSecurityInfo) ac.getBean("dbSecurityInfo");
            MyInvocationSecurityMetadataSource securityMetadataSource = (MyInvocationSecurityMetadataSource) ac
                    .getBean("securityMetadataSource");
            securityMetadataSource.reLoadResourceDefine(dbSecurityInfo);
        }
    }
}

