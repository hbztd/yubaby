package com.example.yubaby.service.home;

import com.example.yubaby.common.ResponseJson;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 19:28
 **/
public interface ArticleService {
    ResponseJson getAllKnowledgeDir();
    ResponseJson getArticleListByDir(int kId, int sId, int start, int size);
}
