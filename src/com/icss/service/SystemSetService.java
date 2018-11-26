package com.icss.service;

import com.icss.dao.*;
import com.icss.model.UserInfo;
import com.icss.model.MenuBean;
import com.icss.model.MenuModel;
import com.icss.model.RoleBean;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemSetService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleBeanMapper roleBeanMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private MenuBeanMapper menuBeanMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    //------------userMapper
    public UserInfo isValidUser(Map conditions) {
        return userMapper.isValidUser(conditions);
    }

    public List<UserInfo> selectAll() {
        return userMapper.selectAll();
    }

    public int addUser(Map<String, Object> conditions) {
        return userMapper.addUser(conditions);
    }

    public int editUser(Map<String, Object> conditions) {
        return userMapper.editUser(conditions);
    }

    public int delUser(Map<String, Object> conditions) {
        return userMapper.delUser(conditions);
    }

    public UserInfo selectUserCode(Map<String, Object> conditions) {
        return userMapper.selectUserCode(conditions);
    }

    public UserInfo selectByUserNo(String userNo){
        return userMapper.selectByUserNo(userNo);
    }


    //------------roleBeanMapper
    //只查询角色表
    public List<RoleBean> getAllRole() {
        return roleBeanMapper.getAllRole();
    }

    //添加角色
    public int addRole(Map conditions) {
        return roleBeanMapper.addRole(conditions);
    }

    public int delRoleById(String roleId) {
        return roleBeanMapper.delRoleById(roleId);
    }

    public List<RoleBean> selectByUserId(String id) {
        return roleBeanMapper.selectByUserId(id);
    }

    public List<RoleBean> selectByModel(RoleBean roleBean) {
        return roleBeanMapper.selectByModel(roleBean);
    }

    //-------userRoleMapper
    // 添加角色
    public int addRoleForUser(Map<String, String> conditions) {
        return userRoleMapper.addRoleForUser(conditions);
    }


    //-----------roleMenuMapper
    public int addRoleMenu(Map conditions) {
        return roleMenuMapper.addRoleMenu(conditions);
    }

    public int delRoleMenuByRoleId(String roleId) {
        return roleMenuMapper.delRoleMenuByRoleId(roleId);
    }


    //-----------menuBeanMapper
    public List<MenuBean> getAllMenu() {
        return menuBeanMapper.getAllMenu();
    }

    public List<MenuModel> selectRoleMenuByModel(MenuModel model) {
        return menuBeanMapper.selectRoleMenuByModel(model);
    }

    public List<MenuModel> getMenuListByRoleName(String roleName) {
        return menuBeanMapper.getMenuListByRoleName(roleName);
    }

    //有待改进
    public List<MenuModel> getMenuListByMenuModel(MenuModel model) {
        return menuBeanMapper.getMenuListByMenuModel(model);
    }
}
