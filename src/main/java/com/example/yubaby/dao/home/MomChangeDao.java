package com.example.yubaby.dao.home;

import com.example.yubaby.pojo.home.MomChange;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MomChangeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MomChange record);

    int insertSelective(MomChange record);

    MomChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MomChange record);

    int updateByPrimaryKey(MomChange record);

    List<MomChange> getList(@Param("start") int start, @Param("size") int size);
}