package com.example.yubaby.service.shop.impl;

import com.example.yubaby.common.Const;
import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.dao.me.UserDao;
import com.example.yubaby.dao.shop.ShopCategoryDao;
import com.example.yubaby.dao.shop.ShopItemDao;
import com.example.yubaby.pojo.shop.ShopCategory;
import com.example.yubaby.pojo.shop.ShopItem;
import com.example.yubaby.service.shop.ShopService;
import com.example.yubaby.vo.ShopItemView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/15 9:38
 **/
@Service
public class ShopServiceImpl implements ShopService {
    private final UserDao userDao;
    private final ShopCategoryDao categoryDao;
    private final ShopItemDao shopItemDao;

    public ShopServiceImpl(UserDao userDao, ShopCategoryDao categoryDao, ShopItemDao shopItemDao) {
        this.userDao = userDao;
        this.categoryDao = categoryDao;
        this.shopItemDao = shopItemDao;
    }


    @Override
    public ResponseJson getIndexList() {
        List<ShopCategory> list = categoryDao.selectByIndex();
        List<Map<String, Object>> resList = new ArrayList<>();
        for(ShopCategory shopCategory: list) {
            Map<String, Object> map = new HashMap<>();
            map.put("categoryId", shopCategory.getId());
            map.put("categoryName", shopCategory.getName());
            map.put("categoryList", shopItemPojoToView(shopItemDao.selectItemByCategoryId(shopCategory.getId(), 0, Const.PEER_PAGE_LENGTH)));
            resList.add(map);
        }
        return ResponseJson.createSuccessWithData("成功", resList);
    }

    @Override
    public ResponseJson getCategory() {
        List<ShopCategory> list = categoryDao.selectByIndex();
        List<ShopCategory> list2 = categoryDao.selectBySource();
        Map<String, Object> resMap = new HashMap<>();
        List<Integer> categoryId = new ArrayList<>();
        List<String> categoryName = new ArrayList<>();
        List<Integer> sourceId = new ArrayList<>();
        List<String> sourceName = new ArrayList<>();
        for(ShopCategory shopCategory: list) {
            categoryId.add(shopCategory.getId());
            categoryName.add(shopCategory.getName());
        }
        for(ShopCategory shopCategory: list2) {
            sourceId.add(shopCategory.getId());
            sourceName.add(shopCategory.getName());
        }
        resMap.put("categoryId", categoryId);
        resMap.put("categoryName", categoryName);
        resMap.put("sourceId", sourceId);
        resMap.put("sourceName", sourceName);
        return ResponseJson.createSuccessWithData("获取成功", resMap);
    }

    @Override
    public ResponseJson addShopItem(ShopItem shopItem) {
        if(shopItemDao.insertSelective(shopItem) > 0){
            return ResponseJson.createDefaultSuccess();
        };
        return ResponseJson.createDefaultError();
    }

    @Override
    public ResponseJson getListByCategory(int categoryId, int start, int size) {
        return ResponseJson.createSuccessWithData("获取成功", shopItemPojoToView(shopItemDao.selectItemByCategoryId(categoryId, start, size)));
    }

    @Override
    public ResponseJson getNextListByCategory(int categoryId, int lastItemId, int start, int size) {
        List<ShopItem> shopItems = shopItemDao.selectNextItemByCategoryId(categoryId, lastItemId, start, size);
        if(shopItems.size() == 0) {
            return ResponseJson.createErrorNoData("没有更多了");
        }
        return ResponseJson.createSuccessWithData("获取成功", shopItemPojoToView(shopItems));
    }

    @Override
    public ResponseJson getAllListByUId(int uId) {
        List<ShopItem> shopItems = shopItemDao.selectAllByUId(uId);
        List<Map> resList = new ArrayList<>();
        for(ShopItem shopItem: shopItems) {
            Map<String, Object> map = new HashMap<>();
            map.put("title", shopItem.getTitle());
            map.put("id", shopItem.getId());
            resList.add(map);
        }
        return ResponseJson.createSuccessWithData("成功", resList);
    }

    @Override
    public ResponseJson deleteById(int id) {
        if(shopItemDao.deleteByPrimaryKey(id)>0) {
            return ResponseJson.createSuccessNoData("删除成功");
        }
        return ResponseJson.createErrorNoData("删除失败");
    }

    private List<ShopItemView> shopItemPojoToView(List<ShopItem> items) {
        List<ShopItemView> list = new ArrayList<>();
        for(ShopItem item: items) {
            ShopItemView shopItemView = new ShopItemView();
            shopItemView.setId(item.getId());
            shopItemView.setCategoryId(item.getId());
            shopItemView.setContent(item.getContent());
            shopItemView.setPrice(item.getPrice());
            shopItemView.setTitle(item.getTitle());
            shopItemView.setLink(item.getLink());
            Map<String, Object> user = new HashMap<>();
            user.put("id", item.getuId());
            user.put("username", userDao.selectByPrimaryKey(item.getuId()).getName());
            shopItemView.setUser(user);
            Map<String, Object> source = new HashMap<>();
            source.put("id", item.getSource());
            source.put("name", categoryDao.selectByPrimaryKey(item.getSource()).getName());
            shopItemView.setSource(source);
            list.add(shopItemView);
        }
        return list;
    }
}
