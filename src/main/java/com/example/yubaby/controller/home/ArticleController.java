package com.example.yubaby.controller.home;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.service.home.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 19:25
 **/
@RestController
@RequestMapping("/api/home/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("getAllKDir")
    public ResponseJson getAllKnowledgeDir(){
        return articleService.getAllKnowledgeDir();
    }

    @GetMapping("getArticleList")
    public ResponseJson getArticleListByDir(int kId, int sId, int start, int size) {
        return articleService.getArticleListByDir(kId, sId, start, size);
    }
}
