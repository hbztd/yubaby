package com.example.yubaby.dao.home;

import com.example.yubaby.pojo.home.KnowledgeArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 19:20
 **/
@Repository
public class KnowledgeArticleDao {
    private final MongoTemplate mongoTemplate;

    public KnowledgeArticleDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<KnowledgeArticle> getArticleByIdList(List<Integer> aIdList){
        Query query = new Query();
        query.addCriteria(Criteria.where("a_id").in(aIdList));
        return mongoTemplate.find(query, KnowledgeArticle.class);
    }
}
