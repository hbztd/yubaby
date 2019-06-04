package com.example.yubaby.service.home.impl;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.dao.home.DirArticleDao;
import com.example.yubaby.dao.home.KnowledgeArticleDao;
import com.example.yubaby.dao.home.KnowledgeDirDao;
import com.example.yubaby.service.home.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 19:28
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    private KnowledgeDirDao knowledgeDirDao;
    private KnowledgeArticleDao knowledgeArticleDao;
    private DirArticleDao dirArticleDao;

    public ArticleServiceImpl(KnowledgeDirDao knowledgeDirDao, KnowledgeArticleDao knowledgeArticleDao, DirArticleDao dirArticleDao) {
        this.knowledgeDirDao = knowledgeDirDao;
        this.knowledgeArticleDao = knowledgeArticleDao;
        this.dirArticleDao = dirArticleDao;
    }

    @Override
    public ResponseJson getAllKnowledgeDir() {
        return knowledgeDirDao.getAllKnowledgeDir();
    }

    @Override
    public ResponseJson getArticleListByDir(int kId, int sId,  int start, int size) {
        List<Integer> list = dirArticleDao.getArticleIdList(kId, sId, start, size);
        if(list == null) {
            return ResponseJson.createErrorNoData("没有更多了");
        }
        return ResponseJson.createSuccessWithData("成功",knowledgeArticleDao.getArticleByIdList(list));
    }
}
