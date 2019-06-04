package com.example.yubaby.service.community;

import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.pojo.community.Shuoshuo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/13 16:47
 **/
public interface SSService {
    ResponseJson addSS(Shuoshuo shuoshuo);
    ResponseJson getSSList(int start, int size); //默认时间排序 id越大越前
    ResponseJson getNextSSList(int lastItemId, int start, int size);
    ResponseJson fileUpload(MultipartFile file);
    ResponseJson filesUpload(List<MultipartFile> files);
    ResponseJson getAllSSListByUId(int uId); // 不考虑分页
    ResponseJson deleteSSById(int id);
}
