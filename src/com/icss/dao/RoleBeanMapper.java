package com.icss.dao;

import com.icss.model.RoleBean;

import java.util.List;
import java.util.Map;

public interface RoleBeanMapper {

    public List<RoleBean> selectByUserId(String paramString);

    public List<RoleBean> selectByModel(RoleBean roleBean);

//    public List<RoleBean> selectByMenuNo(String menuNo);//在MenuBeanMapper.xml被调用

    public List<RoleBean> getAllRole();

    public int addRole(Map conditions);

    public int delRoleById(String roleId);
}
