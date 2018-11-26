package com.icss.dao;

import com.icss.model.UserRole;
import java.util.Map;

public interface UserRoleMapper {

  public int addRoleForUser(Map<String, String> paramMap);
}
