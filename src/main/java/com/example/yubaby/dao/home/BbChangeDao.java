package com.example.yubaby.dao.home;

import com.example.yubaby.pojo.home.BbChange;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbChangeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BbChange record);

    int insertSelective(BbChange record);

    BbChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbChange record);

    int updateByPrimaryKey(BbChange record);

    List<BbChange> getList(@Param("start") int start, @Param("size") int size);
}