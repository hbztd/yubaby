package com.example.yubaby.dao.shop;

import com.example.yubaby.pojo.shop.ShopCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopCategoryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopCategory record);

    int insertSelective(ShopCategory record);

    ShopCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopCategory record);

    int updateByPrimaryKey(ShopCategory record);

    List<ShopCategory> selectByIndex();

    List<ShopCategory> selectBySource();
}