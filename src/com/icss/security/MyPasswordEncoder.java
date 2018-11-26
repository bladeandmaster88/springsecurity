package com.icss.security;

import com.icss.utils.MD5Util;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {
    //获得加密密码
    public String encodePassword(String inputPassWord, Object salt) throws DataAccessException {
        String encodePassword = MD5Util.EncryptStr(inputPassWord);
        return encodePassword;
    }

    //比较数据库密码与加密密码是否相等
    public boolean isPasswordValid(String dbPassWord, String inputPassWord, Object salt) throws DataAccessException {
        String encodePassword = encodePassword(inputPassWord, null);
        if (!dbPassWord.equals(encodePassword)) {
            return false;
        }
        return true;
    }
}



/* Location:           E:\icssnew\20180713icss.zip

 * Qualified Name:     WEB-INF.classes.com.hytera.icss.security.serviceimpl.MyPasswordEncoder

 * JD-Core Version:    0.7.0.1

 */