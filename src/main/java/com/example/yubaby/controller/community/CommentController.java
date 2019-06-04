package com.example.yubaby.controller.community;

import com.example.yubaby.common.Const;
import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.pojo.community.CommentsInfo;
import com.example.yubaby.service.community.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/13 17:13
 **/
@RestController
@RequestMapping("/api/qz/")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("commentList")
    public ResponseJson getListBySSId(int ssId) {
        return commentService.getCommentList(ssId);
    }

    @PostMapping("addComment")
    public ResponseJson addComment(@RequestBody CommentsInfo commentsInfo, HttpSession session) {
        if(commentsInfo.getuId() == (int) session.getAttribute(Const.CURRENT_USER_ID)) {
            return commentService.addComment(commentsInfo);
        }
        return ResponseJson.createErrorNoData("评论失败");
    }
}
