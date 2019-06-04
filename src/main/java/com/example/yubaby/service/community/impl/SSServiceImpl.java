package com.example.yubaby.service.community.impl;

import com.example.yubaby.common.Const;
import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.dao.community.CommentsInfoDao;
import com.example.yubaby.dao.community.ShuoshuoDao;
import com.example.yubaby.dao.me.UserDao;
import com.example.yubaby.pojo.community.Shuoshuo;
import com.example.yubaby.pojo.me.User;
import com.example.yubaby.service.community.SSService;
import com.example.yubaby.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/13 16:47
 **/
@Service
public class SSServiceImpl implements SSService {

    private final ShuoshuoDao shuoshuoDao;
    private final UserDao userDao;
    private final CommentsInfoDao commentsInfoDao;

    public SSServiceImpl(ShuoshuoDao shuoshuoDao, UserDao userDao, CommentsInfoDao commentsInfoDao) {
        this.shuoshuoDao = shuoshuoDao;
        this.userDao = userDao;
        this.commentsInfoDao = commentsInfoDao;
    }

    @Override
    public ResponseJson addSS(Shuoshuo shuoshuo) {
       if(shuoshuoDao.insertSelective(shuoshuo)>0) {
           return ResponseJson.createSuccessNoData("发布成功");
       }
       return ResponseJson.createDefaultError();
    }

    @Override
    public ResponseJson getSSList(int start, int size) {
        List<Shuoshuo> list= shuoshuoDao.getList(start, size);
        return ListPojoToView(list);
    }

    @Override
    public ResponseJson getNextSSList(int lastItemId, int start, int size) {
        List<Shuoshuo> list= shuoshuoDao.getNextList(lastItemId ,start, size);
        if(list.size() == 0) { // 不能判断是否为null
            return ResponseJson.createErrorNoData("无更多内容了");
        }
        return ListPojoToView(list);
    }

    @Override
    public ResponseJson fileUpload(@RequestParam() MultipartFile file) {
        if(file.isEmpty()) {
            return ResponseJson.createErrorNoData("图片不能为空");
        } else {
            try {
                String str = file.getOriginalFilename();
                String str2 = str.replaceAll(" ", "");

                String fileType = str2.split("\\.")[1]; // .无效

                String fileName = TimeUtil.getTimestamp() + "." + fileType;

                Path dest = Paths.get(Const.UPLOADED_FOLDER_QZ + fileName);
                System.out.println(Const.UPLOADED_FOLDER_QZ + fileName);
                System.out.println(dest);
                file.transferTo(dest);
                Thread.sleep(1); // 防止时间戳重复
                return ResponseJson.createSuccessWithData("上传成功", fileName);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseJson.createErrorNoData("出现未知错误，请重试");
            }
        }
    }

    @Override
    public ResponseJson filesUpload(List<MultipartFile> files) {
        for(MultipartFile file: files) {
            if(file.isEmpty()) {
                return ResponseJson.createErrorNoData("图片不能为空");
            }
        }
        try {
            List<String> fileNames = new ArrayList<>();
            for (MultipartFile file : files) {
                String str = file.getOriginalFilename();
                String str2 = str.replaceAll(" ", ""); // 去空

                String fileType = str2.split("\\.")[1]; // .无效

                String fileName = TimeUtil.getTimestamp() + "." + fileType;

                fileNames.add(fileName);

                Path dest = Paths.get(Const.UPLOADED_FOLDER_QZ + fileName);
                file.transferTo(dest);
                Thread.sleep(1); // sleep1ms 防止时间戳重复
            }
            return ResponseJson.createSuccessWithData("上传成功", fileNames);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseJson.createErrorNoData("出现未知错误，请重试");
        }
    }

    @Override
    public ResponseJson getAllSSListByUId(int uId) {
        List<Shuoshuo> ssList = shuoshuoDao.getAllSSListByUId(uId);
        List<Map> resList = new ArrayList<>();
        for(Shuoshuo ss : ssList) {
            Map<String, Object> map = new HashMap<>();
            map.put("title", ss.getTitle());
            map.put("id", ss.getId());
            resList.add(map);
        }
        return ResponseJson.createSuccessWithData("成功", resList);
    }

    @Override
    @Transactional
    public ResponseJson deleteSSById(int id) {
        // 事务 先删除所有评论
        commentsInfoDao.deleteBySSId(id); //  i 可能为0
        if(shuoshuoDao.deleteByPrimaryKey(id)>0) {
            return ResponseJson.createSuccessNoData("删除成功");
        }
        return ResponseJson.createErrorNoData("删除失败");
    }

    private ResponseJson ListPojoToView(List<Shuoshuo> list) {
        List<Map> resList = new ArrayList<>();
        for(Shuoshuo shuoshuo: list) {
            User user = userDao.selectByPrimaryKey(shuoshuo.getuId());
            Map<String, Object> map = new HashMap<>();
            map.put("ss", shuoshuo);
            map.put("user", user);
            resList.add(map);
        }
        return ResponseJson.createSuccessWithData("获取成功",resList);
    }
}
