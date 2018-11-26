package com.icss.controller;

import com.icss.model.MenuModel;
import com.icss.model.RoleBean;
import com.icss.service.SystemSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestApp {

    @Autowired
    private  SystemSetService systemSetService;

    @RequestMapping("")
    public void test(){
        try {
            //SystemSetController --menuBeanMapper
            String roleName = "管理员";
            List<MenuModel> list = systemSetService.getMenuListByRoleName(roleName);

            //SpringSecurityUtils  --menuBeanMapper
            MenuModel model = new MenuModel();
            model.setName(roleName);
            List<MenuModel> list2 = systemSetService.getMenuListByMenuModel(model);

            //DbSecurityInfo  --menuBeanMapper
            MenuModel model2 = new MenuModel();
            Short sh = 1;
            model2.setStatus(sh);
            List<MenuModel> menuModels = systemSetService.selectRoleMenuByModel(model2);//查出所有的菜单

            //--roleBeanMapper
            List<RoleBean> roleBeans = systemSetService.selectByUserId("855d437d-0d1c-4841-9be0-de2b70681fd1");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
