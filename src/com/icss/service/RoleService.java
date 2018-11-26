package com.icss.service;

import com.icss.dao.UserRoleMapper;
import com.icss.model.RoleBean;
import com.icss.model.UserRole;
import com.icss.dao.RoleBeanMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService{
    @Autowired
    private RoleBeanMapper roleBeanMapper;//mapper的接口

    @Autowired
    private UserRoleMapper userRoleMapper;//mapper的接口
}

 