package com.example.yubaby.controller.home;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.service.home.BabyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 19:25
 **/
@RestController
@RequestMapping("/api/home/baby")
public class BabyController {
    private final BabyService babyService;

    public BabyController(BabyService service) {
        this.babyService = service;
    }

    @GetMapping("babyChange")
    public ResponseJson getBabyChange(int start, int size){
        return babyService.getBabyChange(start, size);
    }

    // 一次加载一个月 4week
    @GetMapping("momChange")
    public ResponseJson getMomChange(int day) {
        return babyService.getMomChange(day);
    }

    @GetMapping("getIndex2")
    public ResponseJson getIndex2Info(int day) {
        return babyService.getIndex2Info(day);
    }

    @GetMapping("getIndex3")
    public ResponseJson getIndex3Info(int day) {
        return babyService.getIndex3Info(day);
    }
}
