package com.icss.controller;

import com.icss.model.MenuBean;
import com.icss.model.MenuModel;
import com.icss.model.RoleBean;
import com.icss.model.UserInfo;
import com.icss.service.SystemSetService;
import com.icss.utils.Forward;
import com.icss.utils.GUID;
import com.icss.utils.MD5Util;
import com.icss.security.SpringSecurityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/systemSet")
public class SystemSetController {
    private Logger logger = Logger.getLogger(IndexController.class);
    @Autowired
    private SystemSetService systemSetService;

    @RequestMapping("")
    public String index(HttpServletRequest request) {
        return "page/systemSet";
    }

    @RequestMapping("/noRole")
    public String noRole(HttpServletRequest request) {
        return "noRole";
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public Forward getAllUser(HttpServletRequest request) {
        Forward forward = new Forward();
        try {
            List<UserInfo> icssUserInfolist = this.systemSetService.selectAll();
            forward.setList(icssUserInfolist);
            forward.setSuccess(true);
        } catch (Exception e) {
            forward.setSuccess(false);
            logger.info("用户数据加载失败" + e);
        }
        return forward;
    }

    //新增用户
    @RequestMapping("/addUser")
    @ResponseBody
    public Forward addUser(HttpServletRequest request, String username, String password, String userCode, String roleId) {
        Forward forward = new Forward();
        Map<String, Object> conditions = new HashMap();
        UserInfo icssUserInfo = (UserInfo) request.getSession().getAttribute("user");
        String guid = GUID.getGuid();
        conditions.put("guid", guid);
        conditions.put("status", "1");
        conditions.put("password", MD5Util.EncryptStr(password));
        conditions.put("name", username);
        conditions.put("userCode", userCode);
        conditions.put("createUser", icssUserInfo.getUserCode());
        conditions.put("updateUser", icssUserInfo.getUserCode());
        conditions.put("createTime", new Date());
        conditions.put("updateTime", new Date());
        UserInfo tempUser = this.systemSetService.selectUserCode(conditions);//判断数据库是不是存在重复的的userCode
        if (tempUser == null) {
            try {

                int flag = this.systemSetService.addUser(conditions);
                if (flag > 0) {
                    forward.setSuccess(true);
                } else {
                    forward.setSuccess(false);
                }
            } catch (Exception e) {
                forward.setSuccess(false);
                this.logger.info("新增用户失败" + e);
            }
        }
        //增加用户之后需要给新用户分配角色
        Map<String, String> conditions2 = new HashMap();
        conditions2.put("userId", guid);
        conditions2.put("roleId", roleId);
        conditions2.put("id", GUID.getGuid());
        int flag = this.systemSetService.addRoleForUser(conditions2);
        return forward;
    }

    //编辑用户
    @RequestMapping("/editUser")
    @ResponseBody
    public Forward editUser(HttpServletRequest request, String username, String password, String usercode) {
        Forward forward = new Forward();
        Map<String, Object> conditions = new HashMap();
        UserInfo icssUserInfo = (UserInfo) request.getSession().getAttribute("user");
        conditions.put("password", MD5Util.EncryptStr(password));
        conditions.put("name", username);
        conditions.put("userCode", usercode);
        conditions.put("updateUser", icssUserInfo.getUserCode());
        conditions.put("updateTime", new Date());
        try {
            int flag = this.systemSetService.editUser(conditions);
            if (flag > 0) {
                forward.setSuccess(true);
            } else {
                forward.setSuccess(false);
                forward.setMsg("编辑用户失败");
            }
        } catch (Exception e) {
            forward.setSuccess(false);
            logger.info("编辑用户失败" + e);
        }
        return forward;
    }

    //删除用户
    @RequestMapping("/delUser")
    @ResponseBody
    public Forward delUser(HttpServletRequest request, String userCode, String status) {
        Forward forward = new Forward();
        if (!userCode.equals("admin")) {
            Map<String, Object> conditions = new HashMap();
            UserInfo icssUserInfo = (UserInfo) request.getSession().getAttribute("user");
            conditions.put("status", status);
            conditions.put("userCode", userCode);
            conditions.put("updateUser", icssUserInfo.getName());
            conditions.put("updateTime", new Date());
            try {
                int flag = this.systemSetService.delUser(conditions);
                if (flag > 0) {
                    forward.setSuccess(true);
                } else {
                    forward.setSuccess(false);
                    forward.setMsg("删除用户失败");
                }
            } catch (Exception e) {
                forward.setSuccess(false);
                this.logger.info("删除用户失败" + e);
            }
        } else {
            forward.setSuccess(false);
        }
        return forward;
    }


    @ResponseBody
    @RequestMapping("/getAllRole")
    public Forward getAllRole(HttpServletRequest request) {
        Forward forward = new Forward();
        try {
            List<RoleBean> list = this.systemSetService.getAllRole();
            forward.setList(list);
            forward.setSuccess(true);
        } catch (Exception e) {
            forward.setSuccess(false);
            logger.info("获取所有角色失败" + e);
        }
        return forward;
    }

    /*
    *@param roleName角色名 比如"管理员"
    * */
    @ResponseBody
    @RequestMapping("/getMenuByRole")
    public Forward getMenuByRole(HttpServletRequest request, String roleName) {
        Forward forward = new Forward();
        try {
            List<MenuModel> list = this.systemSetService.getMenuListByRoleName(roleName);
            forward.setList(list);
            forward.setSuccess(true);
        } catch (Exception e) {
            forward.setSuccess(false);
            logger.info("根据角色获取菜单失败" + e);
        }
        return forward;
    }

    @ResponseBody
    @RequestMapping("/getAllMenu")
    public Forward getAllMenu(HttpServletRequest request) {
        Forward forward = new Forward();
        try {
            List<MenuBean> list = this.systemSetService.getAllMenu();
            forward.setList(list);
            forward.setSuccess(true);
        } catch (Exception e) {
            forward.setSuccess(false);
            logger.info("获取所有菜单失败" + e);
        }
        return forward;
    }

    //新增角色
    @ResponseBody
    @RequestMapping("/addRole")
    public Forward addRole(HttpServletRequest request, String roleName, String menuNoStr) {
        Forward forward = new Forward();
        try {
            Map<String, String> conditions = new HashMap();
            conditions.put("roleName", roleName);
            String roleId = GUID.getGuid();
            conditions.put("roleId", roleId);
            int flag = this.systemSetService.addRole(conditions);
            if (flag > 0) {
                String[] menuArr = menuNoStr.split(",");
                for (int i = 0; i < menuArr.length; i++) {
                    String id = GUID.getGuid();
                    Map<String, String> conditions2 = new HashMap();
                    conditions2.put("id", id);
                    conditions2.put("roleId", roleId);
                    conditions2.put("menuNo", menuArr[i]);
                    int flag2 = systemSetService.addRoleMenu(conditions2);
                }
                forward.setSuccess(true);
                SpringSecurityUtils.reloadRoleMenu(request);
            }
        } catch (Exception e) {
            forward.setSuccess(false);
            logger.info("新增角色失败" + e);
        }
        return forward;
    }

    //编辑角色
    @ResponseBody
    @RequestMapping("/editRole")
    public Forward editRole(HttpServletRequest request, String roleId, String menuNoStr) {
        Forward forward = new Forward();
        try {
            int flag = this.systemSetService.delRoleMenuByRoleId(roleId);
            String[] menuArr = menuNoStr.split(",");
            for (int i = 0; i < menuArr.length; i++) {
                String id = GUID.getGuid();
                Map<String, String> conditions = new HashMap();
                conditions.put("id", id);
                conditions.put("roleId", roleId);
                conditions.put("menuNo", menuArr[i]);
                int flag2 = this.systemSetService.addRoleMenu(conditions);
            }
            forward.setSuccess(true);
            SpringSecurityUtils.reloadRoleMenu(request);
        } catch (Exception e) {
            forward.setSuccess(false);
            logger.info("修改角色失败" + e);
        }
        return forward;
    }

    //删除角色
    @ResponseBody
    @RequestMapping("/delRole")
    public Forward delRole(HttpServletRequest request, String roleId) {
        Forward forward = new Forward();
        try {
            int flag = this.systemSetService.delRoleMenuByRoleId(roleId);
            if (flag > 0) {
                int i = this.systemSetService.delRoleById(roleId);
            }
            forward.setSuccess(true);
            SpringSecurityUtils.reloadRoleMenu(request);
        } catch (Exception e) {
            forward.setSuccess(false);
            this.logger.info("删除角色失败" + e);
        }
        return forward;
    }

    @ResponseBody
    @RequestMapping({"/addRoleForUser"})
    public Forward addRoleForUser(HttpServletRequest request, String userId, String roleId) {
        Forward forward = new Forward();
        try {
            Map<String, String> conditions = new HashMap();
            conditions.put("userId", userId);
            conditions.put("roleId", roleId);
            conditions.put("id", GUID.getGuid());
            int flag = this.systemSetService.addRoleForUser(conditions);
            forward.setSuccess(true);
        } catch (Exception e) {
            forward.setSuccess(false);
            this.logger.info("为用户绑定角色" + e);
        }
        return forward;
    }
}
