package com.icss.security;

import com.icss.model.RoleBean;
import com.icss.service.RoleService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.icss.service.SystemSetService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static final Logger logger = Logger.getLogger(MyInvocationSecurityMetadataSource.class);
    private UrlMatcher urlMatcher = new AntUrlPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    @Autowired
    private SystemSetService systemSetService;

    public MyInvocationSecurityMetadataSource(DbSecurityInfo dbSecurityInfo) {
        resourceMap = dbSecurityInfo.loadResourceDefine();
    }

    public void reLoadResourceDefine(DbSecurityInfo dbSecurityInfo) {
        resourceMap = dbSecurityInfo.loadResourceDefine();
    }

    //FilterInvocation对象
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        String url = ((FilterInvocation) object).getRequestUrl();
        url = url.split("\\?")[0];
        if (this.urlMatcher.pathMatchesUrl(url, "/system/login")) {
            return null;
        }
        logger.debug("访问的url 是：" + url);
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = (String) ite.next();
            logger.debug("resURL 是：" + resURL);
            if (this.urlMatcher.pathMatchesUrl(url, resURL)) {
                logger.debug("resURL 是：" + resURL);
                return (Collection) resourceMap.get(resURL);
            }
        }
        return loadAllResourceDefine();
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    protected Collection<ConfigAttribute> loadAllResourceDefine() {
        Collection<ConfigAttribute> configAttributes = new HashSet();
        try {
            RoleBean roleModel = new RoleBean();
            roleModel.setStatus(Short.valueOf(new Integer(1).shortValue()));

            List<RoleBean> list = systemSetService.selectByModel(roleModel);//查询出所有可用的角色
            for (RoleBean bean : list) {
                ConfigAttribute configAttribute = new SecurityConfig(bean.getName());
                configAttributes.add(configAttribute);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return configAttributes;
    }
}