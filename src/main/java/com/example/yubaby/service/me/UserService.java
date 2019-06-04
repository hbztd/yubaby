package com.example.yubaby.service.me;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.pojo.me.BabyInfo;

import javax.servlet.http.HttpSession;

public interface UserService {
    ResponseJson login(String account, String password, HttpSession session);
    ResponseJson checkAccount(String account);
    ResponseJson checkCode(String account, String code);
    ResponseJson sendCode(String account, String mail);
    ResponseJson sendCode2(String account);
    ResponseJson register(String account, String name, String password, String mail, String code);
    ResponseJson findPw(String account, String password, String code);
    ResponseJson changePw(String oldPw, String newPw, int id, String account);
    ResponseJson addBabyInfo(BabyInfo babyInfo);
    ResponseJson updateBabyInfo(BabyInfo babyInfo);
}
