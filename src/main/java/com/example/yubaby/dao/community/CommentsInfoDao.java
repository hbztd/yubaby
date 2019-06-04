package com.example.yubaby.dao.community;

import com.example.yubaby.pojo.community.CommentsInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentsInfo record);

    int insertSelective(CommentsInfo record);

    CommentsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentsInfo record);

    int updateByPrimaryKey(CommentsInfo record);

    List<CommentsInfo> getListBySSId(int ssId);

    int deleteBySSId(int SSId);
}