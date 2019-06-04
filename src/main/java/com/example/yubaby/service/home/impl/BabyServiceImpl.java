package com.example.yubaby.service.home.impl;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.dao.home.BabyChangeDao;
import com.example.yubaby.dao.home.BbChangeDao;
import com.example.yubaby.dao.home.MomChangeDao;
import com.example.yubaby.pojo.home.BabyChange;
import com.example.yubaby.pojo.home.BbChange;
import com.example.yubaby.pojo.home.MomChange;
import com.example.yubaby.service.home.BabyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/19 17:32
 **/
@Service
public class BabyServiceImpl implements BabyService {
    private final BbChangeDao bbChangeDao;
    private final MomChangeDao momChangeDao;
    private final BabyChangeDao babyChangeDao;

    public BabyServiceImpl(BbChangeDao bbChangeDao, MomChangeDao momChangeDao, BabyChangeDao babyChangeDao) {
        this.bbChangeDao = bbChangeDao;
        this.momChangeDao = momChangeDao;
        this.babyChangeDao = babyChangeDao;
    }

    @Override
    public ResponseJson getBabyChange(int start, int size) {
        List<BbChange> list = bbChangeDao.getList(start, size);
        if(list.size() == 0) {
            return ResponseJson.createErrorNoData("没有更多了");
        }
        return ResponseJson.createSuccessWithData("成功", list);
    }

    @Override
    public ResponseJson getMomChange(int day) {
        int week = day%7 == 0 ? day/7 : day/7 + 1; //第七天是第一周
        return ResponseJson.createSuccessWithData("成功", momChangeDao.selectByPrimaryKey(week));
    }

    @Override
    public ResponseJson getIndex2Info(int day) {
        int week = day%7 == 0 ? day/7 : day/7 + 1;
        BbChange bbChange = bbChangeDao.selectByPrimaryKey(day);
        MomChange momChange = momChangeDao.selectByPrimaryKey(week);
        BabyChange babyChange = babyChangeDao.getBabyChangeInfoByWeek(week);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("bbChange", bbChange);
        resMap.put("momChange", momChange);
        resMap.put("babyChange", babyChange);
        return ResponseJson.createSuccessWithData("成功", resMap);
    }

    @Override
    public ResponseJson getIndex3Info(int day) {
        int month = day/30 + 1; //有误差
        return ResponseJson.createSuccessWithData("成功",babyChangeDao.getBabyChange2InfoByMonth(month));
    }
}
