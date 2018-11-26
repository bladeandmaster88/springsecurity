package com.icss.dao;

import com.icss.model.UserInfo;
import com.icss.model.UserRole;

import java.util.List;
import java.util.Map;

public interface UserMapper {

   public UserInfo isValidUser(Map conditions);

   public List<UserInfo> selectAll();

   public int addUser(Map<String, Object> conditions);

    public int editUser(Map<String, Object> conditions);

    public int delUser(Map<String, Object> conditions);

    UserInfo selectUserCode(Map<String, Object> conditions);

    public UserInfo selectByUserNo(String userNo);
}
