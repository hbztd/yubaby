package com.example.yubaby.dao.home;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.pojo.home.KnowledgeDir;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 19:19
 **/
@Repository
public class KnowledgeDirDao {
    private final MongoTemplate mongoTemplate;

    public KnowledgeDirDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ResponseJson getAllKnowledgeDir() {
        return ResponseJson.createSuccessWithData("成功", mongoTemplate.findAll(KnowledgeDir.class));
    }
}
