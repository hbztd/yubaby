package com.example.yubaby.controller.shop;

import com.example.yubaby.common.Const;
import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.pojo.shop.ShopItem;
import com.example.yubaby.service.shop.ShopService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/15 9:33
 **/
@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("add")
    public ResponseJson addShopItem(@RequestBody ShopItem item, HttpSession session) {
        item.setuId((int)session.getAttribute(Const.CURRENT_USER_ID));
        return shopService.addShopItem(item);
    }

    @GetMapping("category")
    public ResponseJson getCategory() {
        return shopService.getCategory();
    }

    @GetMapping("index")
    public ResponseJson getIndexList() {
        return shopService.getIndexList();
    }

//    获取最新的数据 上拉刷新
    @GetMapping("list")
    public ResponseJson getListByCategory(int categoryId, int start, int size) {
        return shopService.getListByCategory(categoryId, start, size);
    }

//  通过比较最后一项的大小确定下一页 下拉刷新
    @GetMapping("nextList")
    public ResponseJson getNextListByCategory(int categoryId, int lastItemId, int start, int size) {
        return shopService.getNextListByCategory(categoryId, lastItemId, start, size);
    }

    @GetMapping("uList")
    public ResponseJson getAllListByUId(int uId) {
        return shopService.getAllListByUId(uId);
    }

    @DeleteMapping("deleteItem")
    public ResponseJson deleteById(int id){
        return shopService.deleteById(id);
    }
}
