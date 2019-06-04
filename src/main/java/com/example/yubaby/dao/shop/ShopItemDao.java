package com.example.yubaby.dao.shop;

import com.example.yubaby.pojo.shop.ShopItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopItemDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopItem record);

    int insertSelective(ShopItem record);

    ShopItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopItem record);

    int updateByPrimaryKey(ShopItem record);

    List<ShopItem> selectItemByCategoryId(@Param("categoryId")int categoryId, @Param("start")int start, @Param("end")int end);

    List<ShopItem> selectNextItemByCategoryId(@Param("categoryId")int categoryId, @Param("lastItemId")int lastItemId, @Param("start")int start, @Param("end")int end);

    List<ShopItem> selectAllByUId(int uId);
}