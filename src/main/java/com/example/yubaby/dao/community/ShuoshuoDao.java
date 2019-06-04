package com.example.yubaby.dao.community;

import com.example.yubaby.pojo.community.Shuoshuo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShuoshuoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Shuoshuo record);

    int insertSelective(Shuoshuo record);

    Shuoshuo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shuoshuo record);

    int updateByPrimaryKeyWithBLOBs(Shuoshuo record);

    int updateByPrimaryKey(Shuoshuo record);

    List<Shuoshuo> getList(@Param("start")int start, @Param("size")int size);

    List<Shuoshuo> getNextList(@Param("lastItemId")int lastItemId, @Param("start")int start, @Param("size")int size);

    List<Shuoshuo> getAllSSListByUId(int uId);
}