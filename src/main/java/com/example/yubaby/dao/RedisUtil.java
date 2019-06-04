package com.example.yubaby.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 14:03
 **/
@Component
public class RedisUtil {
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 设置验证码 5分钟过期
    public boolean setCode(String key) {
        String baseLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String baseNumber = "132456789";
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for(int i=0; i<4; i++) {
          int j = random.nextInt(35);
          if(j < 26) {
              code.append(baseLetter.substring(j, j + 1));
          } else {
              code.append(baseNumber.substring(j-26, j-25));
          }
        }
        try{
            redisTemplate.opsForValue().set(key, code.toString(), 30, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 获取验证码
    public String getCode(String key) {
        return (String)redisTemplate.opsForValue().get(key);
    }

    // 删除验证码
    public boolean removeCode(String key) {
        try{
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//    ttl key 查看剩余过期时间 -2 不存在该key -1存在但为设置时间 秒单位
}
