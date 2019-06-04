package com.example.yubaby.dao.me;

import com.example.yubaby.pojo.me.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByLogin(@Param("account") String account, @Param("password") String password);

    int checkByAccount(String account);

    int updatePasswordByAccount(@Param("account") String account, @Param("password") String password);

    User selectByAccount(String account);

    int updatePwByChange(@Param("oldPw")String oldPw, @Param("newPw")String newPw, @Param("id") int id);
}