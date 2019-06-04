package com.example.yubaby.dao.home;

import com.example.yubaby.pojo.home.BabyChange;
import com.example.yubaby.pojo.home.BabyChange2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/20 7:19
 **/
@Repository
public class BabyChangeDao {
    private final MongoTemplate mongoTemplate;

    public BabyChangeDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
//  怀
    public BabyChange getBabyChangeInfoByWeek(int week) {
        Query query = new Query();
        query.addCriteria(Criteria.where("week").is(week));
        return mongoTemplate.findOne(query, BabyChange.class);
    }
//  有
    public BabyChange2 getBabyChange2InfoByMonth(int month) {
        Query query = new Query();
        query.addCriteria(Criteria.where("month").is(month));
        return mongoTemplate.findOne(query, BabyChange2.class);
    }
}
