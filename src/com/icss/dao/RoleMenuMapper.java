package com.icss.dao;

import com.icss.model.RoleBean;

import java.util.List;
import java.util.Map;

public interface RoleMenuMapper {

    public int addRoleMenu(Map conditions);

    public int delRoleMenuByRoleId(String roleId);
}
