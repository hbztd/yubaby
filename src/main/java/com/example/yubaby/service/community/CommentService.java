package com.example.yubaby.service.community;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.pojo.community.CommentsInfo;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/13 17:14
 **/
public interface CommentService {
    ResponseJson addComment(CommentsInfo commentsInfo);
    ResponseJson getCommentList(int ssId); //未分页
}
