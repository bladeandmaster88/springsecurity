package com.icss.security;

import com.icss.model.RoleBean;
import com.icss.model.UserInfo;
import com.icss.service.SystemSetService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyUserDetailsService implements UserDetailsService {
    private static final Logger logger = Logger.getLogger(MyUserDetailsService.class);
    @Autowired
    private SystemSetService systemSetService;

    public UserDetails loadUserByUsername(String userCode)
            throws UsernameNotFoundException, DataAccessException {
        UserInfo userInfo = null;
        try {
            userInfo = this.systemSetService.selectByUserNo(userCode);
        } catch (Exception e) {
            logger.info("根据userCode查询用户出现异常：" + e);
        }
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户:" + userCode + "不存在");
        }
        Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(userInfo);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        String password = userInfo.getPassword();
        OperatorDetails userDetails = new OperatorDetails(userCode, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, grantedAuths);
        userDetails.setLoginTime(new Date());
        return userDetails;
    }

    private Set<GrantedAuthority> obtainGrantedAuthorities(UserInfo userInfo) {
        Set<GrantedAuthority> authSet = new HashSet<>();
        try {
            List<RoleBean> roleBeans = systemSetService.selectByUserId(userInfo.getGuid());
            logger.info("当前用户的角色-start");
            for (RoleBean roleBean : roleBeans) {
                logger.info("---" + roleBean.getName());
                authSet.add(new GrantedAuthorityImpl(roleBean.getName()));//用角色名称代表权限
            }
            logger.info("当前用户的角色-end");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authSet;
    }
}
