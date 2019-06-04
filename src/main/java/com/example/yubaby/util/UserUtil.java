package com.example.yubaby.util;

import com.example.yubaby.common.Const;
import org.springframework.util.DigestUtils;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 15:23
 **/
public class UserUtil {
    public static String getMd5Password(String account, String password){
//        加入用户名 使相同密码的用户 md5值不同
//        加入salt 增加破解难度
        String md5Password = DigestUtils.md5DigestAsHex((account+password+ Const.SALT).getBytes());
//        加密两次
        md5Password = DigestUtils.md5DigestAsHex((md5Password+Const.SALT).getBytes());
        return md5Password;
    }

    public static String getAvatar(String mail){
        return Const.GRAVATAR+DigestUtils.md5DigestAsHex(mail.getBytes())+"?s=45";
    }
}
