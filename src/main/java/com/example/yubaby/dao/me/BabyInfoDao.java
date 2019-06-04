package com.example.yubaby.dao.me;

import com.example.yubaby.pojo.me.BabyInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface BabyInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BabyInfo record);

    int insertSelective(BabyInfo record);

    BabyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BabyInfo record);

    int updateByPrimaryKey(BabyInfo record);

    BabyInfo selectByUid(int uid);
}