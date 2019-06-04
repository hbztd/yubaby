package com.example.yubaby.service.shop;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.pojo.shop.ShopItem;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/15 9:35
 **/
public interface ShopService {
    ResponseJson getIndexList();
    ResponseJson getCategory();
    ResponseJson addShopItem(ShopItem shopItem);
    ResponseJson getListByCategory(int categoryId, int start, int size);
    ResponseJson getNextListByCategory(int categoryId, int lastItemId, int start, int size);
    ResponseJson getAllListByUId(int uId);
    ResponseJson deleteById(int id);
}
