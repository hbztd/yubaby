package com.example.yubaby.controller.me;

import com.example.yubaby.common.Const;
import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.pojo.me.BabyInfo;
import com.example.yubaby.service.me.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 11:02
 **/
@RestController
@RequestMapping("/api/me/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    ResponseJson login(String account, String password, HttpSession session) {
        return userService.login(account, password, session);
    }

    @PostMapping("checkAccount")
    ResponseJson checkAccount(String account) {
        return userService.checkAccount(account);
    }

    @PostMapping("checkCode")
    ResponseJson checkCode(String account, String code) {
        return userService.checkCode(account, code);
    }

    @GetMapping("sendCode")
    ResponseJson sendCode(String account, String mail) {
        return userService.sendCode(account, mail);
    }

    @PostMapping("register")
    ResponseJson register(String account, String name, String password, String mail, String code) {
        return userService.register(account, name, password, mail, code);
    }

    @PostMapping("findPw")
    ResponseJson findPw(String account, String password, String code) {
        return userService.findPw(account, password, code);
    }

    @PostMapping("changePw")
    ResponseJson changePw(String oldPw, String newPw, HttpSession session) {
        return userService.changePw(oldPw, newPw, (int) session.getAttribute(Const.CURRENT_USER_ID), (String) session.getAttribute(Const.CURRENT_USER_ACCOUNT));
    }

    @GetMapping("sendCode2")
    ResponseJson sendCodeByAccount(String account) {
        return userService.sendCode2(account);
    }

    @PostMapping("addBabyInfo")
    ResponseJson addBabyInfo(@RequestBody BabyInfo babyInfo){
        return userService.addBabyInfo(babyInfo);
    }
    @PutMapping("updateBabyInfo")
    ResponseJson updateBabyInfo(@RequestBody BabyInfo babyInfo, HttpSession session){
        babyInfo.setuId((int)session.getAttribute(Const.CURRENT_USER_ID));
        return userService.updateBabyInfo(babyInfo);
    }

}
