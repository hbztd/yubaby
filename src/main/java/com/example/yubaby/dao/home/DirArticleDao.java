package com.example.yubaby.dao.home;

import com.example.yubaby.pojo.home.DirArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 19:20
 **/
@Repository
public class DirArticleDao {
    private final MongoTemplate mongoTemplate;

    public DirArticleDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Integer> getArticleIdList(int kId, int sId, int start, int size) {
//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.match(Criteria.where("k_id").is(""+kId)),
//                Aggregation.match(Criteria.where("s_id").is(""+sId)),
//                Aggregation.unwind("$item"),
//                Aggregation.project("item"),
//                Aggregation.skip(start),
//                Aggregation.limit(size)
//        );
        Query query = new Query();
        query.addCriteria(new Criteria("k_id").is(""+kId)); //此处是str
        query.addCriteria(new Criteria("s_id").is(""+sId)); //此处是str
        DirArticle dirArticle = mongoTemplate.findOne(query, DirArticle.class);
        int articleSize = dirArticle.getItem().size();
        if(articleSize < start) { // 从小到大判断
            return null;
        }
        if(articleSize < start+size) {
            return dirArticle.getItem().subList(start, articleSize);
        }
//        此处start 是下标索引中的index(0开始)
//        在数据库中 start, size是skip(跳过) start 获取size个元素
        return dirArticle.getItem().subList(start, start+size);
    }
}
