package com.example.yubaby.service.me.impl;

import com.example.yubaby.common.Const;
import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.dao.RedisUtil;
import com.example.yubaby.dao.me.BabyInfoDao;
import com.example.yubaby.dao.me.UserDao;
import com.example.yubaby.pojo.me.BabyInfo;
import com.example.yubaby.pojo.me.User;
import com.example.yubaby.service.me.UserService;
import com.example.yubaby.util.UserUtil;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 11:03
 **/
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final BabyInfoDao babyInfoDao;
    private final JavaMailSender mailSender;
    private final RedisUtil redisUtil;


    public UserServiceImpl(UserDao userDao, BabyInfoDao babyInfoDao, JavaMailSender mailSender, RedisUtil redisUtil) {
        this.userDao = userDao;
        this.babyInfoDao = babyInfoDao;
        this.mailSender = mailSender;
        this.redisUtil = redisUtil;
    }

    public ResponseJson login(String account, String password, HttpSession session) {
        User user = userDao.selectByLogin(account, UserUtil.getMd5Password(account, password));
        if(user == null) {
            return ResponseJson.createErrorNoData("用户名或密码错误");
        }
        BabyInfo babyInfo = babyInfoDao.selectByUid(user.getId());
        getDay(babyInfo);
        Map<String, Object> res = new HashMap<>();
        res.put("user", user);
        res.put("babyInfo", babyInfo);
        session.setAttribute(Const.CURRENT_USER_ID, user.getId());
        session.setAttribute(Const.CURRENT_USER_ACCOUNT, user.getAccount());
        return ResponseJson.createSuccessWithData("登录成功", res);
    }

    @Override
    public ResponseJson checkAccount(String account) {
        if(userDao.checkByAccount(account) > 0) {
            return ResponseJson.createErrorNoData("该用户名已存在");
        }
        return ResponseJson.createDefaultSuccess();
    }

    @Override
    public ResponseJson checkCode(String account, String code) {
        if(redisUtil.getCode(account) != null && redisUtil.getCode(account).equals(code)) {
            return ResponseJson.createDefaultSuccess();
        }
        return ResponseJson.createErrorNoData("验证码错误或过期");
    }

    @Override
    public ResponseJson sendCode(String account, String mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("18871012713@163.com");
        mailMessage.setTo(mail);
        mailMessage.setSubject("育宝宝邮件");
        if(redisUtil.setCode(account)) {
            String code = redisUtil.getCode(account);
            mailMessage.setText("你的验证码："+ code +"，有效期30分钟");
            mailSender.send(mailMessage);
            return ResponseJson.createSuccessNoData("发送成功");
        }
        return ResponseJson.createErrorNoData("发送失败");
    }

    @Override
    public ResponseJson sendCode2(String account) {
        String mail = userDao.selectByAccount(account).getMail();
        return sendCode(account, mail);
    }

    public ResponseJson register(String account, String name, String password, String mail, String code) {
        ResponseJson check = checkAccount(account);
        if(!check.isSuccess()){
            return check;
        }
        check = checkCode(account, code);
        if(!check.isSuccess()){
            return check;
        }
        User user = new User();
        user.setAvatar(UserUtil.getAvatar(mail));
        user.setPassword(UserUtil.getMd5Password(account, password));
        user.setAccount(account);
        user.setName(name);
        user.setMail(mail);
        if(userDao.insert(user) > 0) {
            return ResponseJson.createSuccessWithData("注册成功",user.getId()); //返回主键Id
        }
        return ResponseJson.createErrorNoData("注册失败");
    }

    public ResponseJson findPw(String account, String password, String code) {
        ResponseJson check = checkCode(account, code);
        if(!check.isSuccess()){
            return check;
        }
        if(userDao.updatePasswordByAccount(account, password) > 0) {
            return ResponseJson.createSuccessNoData("修改成功");
        }
        return ResponseJson.createDefaultError();
    }

    @Override
    public ResponseJson changePw(String oldPw, String newPw, int id, String account) {
        if(userDao.updatePwByChange(UserUtil.getMd5Password(account, oldPw), UserUtil.getMd5Password(account, newPw), id)>0) {
            return ResponseJson.createSuccessNoData("成功");
        }
        return ResponseJson.createErrorNoData("原密码错误或其他原因");
    }

    @Override
    public ResponseJson addBabyInfo(BabyInfo babyInfo) {
        if(babyInfoDao.insert(babyInfo) > 0) {
            return ResponseJson.createSuccessWithData("添加成功", babyInfo);
        }
        return ResponseJson.createErrorNoData("添加失败");
    }

    @Override
    public ResponseJson updateBabyInfo(BabyInfo babyInfo) {
        if(babyInfoDao.updateByPrimaryKey(babyInfo) > 0) {
            getDay(babyInfo);
            return ResponseJson.createSuccessWithData("添加成功", babyInfo);
        }
        return ResponseJson.createErrorNoData("添加失败");
    }


    private void getDay(BabyInfo babyInfo) {
        LocalDate localDate = new LocalDate(babyInfo.getDay());
        LocalDate now = new LocalDate();
        int days = Days.daysBetween(localDate, now).getDays();
        days = days>0?days: -days;
        babyInfo.setDay(""+days);
    }
}
