package com.example.yubaby.service.home;

import com.example.yubaby.common.ResponseJson;
import org.springframework.web.bind.annotation.GetMapping;

public interface BabyService {
    ResponseJson getBabyChange(int start, int size);

    ResponseJson getMomChange(int day);

    ResponseJson getIndex2Info(int day);

    ResponseJson getIndex3Info(int month);
}
