package com.icss.dao;

import com.icss.model.MenuBean;
import com.icss.model.MenuModel;

import java.util.List;

public interface MenuBeanMapper {

    public List<MenuBean> getAllMenu();

    public List<MenuModel> selectRoleMenuByModel(MenuModel paramMenuModel);

    public List<MenuModel> getMenuListByRoleName(String paramString);

    public List<MenuModel> getMenuListByMenuModel(MenuModel paramMenuModel);
}
