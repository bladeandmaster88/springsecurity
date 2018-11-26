package com.icss.security;

import com.icss.model.MenuModel;
import com.icss.model.RoleBean;
import com.icss.service.MenuService;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.icss.service.SystemSetService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Component;

@Component
public class DbSecurityInfo {
    private static Logger log = Logger.getLogger(DbSecurityInfo.class);
    @Autowired
    private SystemSetService systemSetService;

    public Map<String, Collection<ConfigAttribute>> loadResourceDefine() {
        Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap();
        try {
            MenuModel model = new MenuModel();
            Short sh = 1;
            model.setStatus(sh);
            List<MenuModel> menuModels = systemSetService.selectRoleMenuByModel(model);//查出所有的菜单
            for (MenuModel menuModel : menuModels) {
                //获取一个url对应的角色，权限集合
                Collection<ConfigAttribute> configAttributes = new HashSet<ConfigAttribute>();
                for (RoleBean bean : menuModel.getRoles()) {
                    ConfigAttribute configAttribute = new SecurityConfig(bean.getName());
                    configAttributes.add(configAttribute);
                }
                resourceMap.put(menuModel.getMenuUrl(), configAttributes);
                Iterator<ConfigAttribute> ite = configAttributes.iterator();
                while (ite.hasNext()) {
                    ConfigAttribute ca = ite.next();
                    String needRole = ((SecurityConfig) ca).getAttribute();
                    log.info("菜单" + menuModel.getMenuUrl() + " 角色" + needRole);
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
        return resourceMap;
    }
}
