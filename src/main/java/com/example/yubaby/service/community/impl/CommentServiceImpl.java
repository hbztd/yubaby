package com.example.yubaby.service.community.impl;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.dao.community.CommentsInfoDao;
import com.example.yubaby.pojo.community.CommentsInfo;
import com.example.yubaby.service.community.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/13 17:14
 **/
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentsInfoDao commentsInfoDao;

    public CommentServiceImpl(CommentsInfoDao commentsInfoDao) {
        this.commentsInfoDao = commentsInfoDao;
    }

    @Override
    public ResponseJson addComment(CommentsInfo commentsInfo) {
        return ResponseJson.createSuccessWithData("成功", commentsInfoDao.insertSelective(commentsInfo));
    }

    @Override
    public ResponseJson getCommentList(int ssId) {
        return ResponseJson.createSuccessWithData("成功", commentsInfoDao.getListBySSId(ssId));
    }
}
