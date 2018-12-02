package com.icss.security;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager {
    private static final Logger logger = Logger.getLogger(MyAccessDecisionManager.class);

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null) {
            return;
        }
        logger.debug("正在访问的url是：" + object.toString()); // object is a URL.
        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        //configAttributes保存的是可以访问object（url)这个url的所有角色
        //判断当前访问这个url的角色是不是configAttributes中的角色
        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            String needRole = ((SecurityConfig) ca).getAttribute();//获得角色名称
            logger.debug("neddRole is:" + needRole);
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needRole.equals(ga.getAuthority())) { // ga is user's role.
                    logger.debug("判断到，needRole 是" + needRole + ",用户的角色是:" + ga.getAuthority() + "，授权数据相匹配");
                    return;
                }
            }
        }
        throw new AccessDeniedException("没有权限");//表示当前角色没有在configAttributes，
    }

    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
}
