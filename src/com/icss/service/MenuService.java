package com.icss.service;

import com.icss.dao.MenuBeanMapper;
import com.icss.model.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuBeanMapper menuBeanMapper;//mapper的接口
}
