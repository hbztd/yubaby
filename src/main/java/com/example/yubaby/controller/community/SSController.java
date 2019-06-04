package com.example.yubaby.controller.community;

import com.example.yubaby.common.Const;
import com.example.yubaby.common.ResponseJson;
import com.example.yubaby.pojo.community.Shuoshuo;
import com.example.yubaby.service.community.SSService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/13 15:55
 **/
@RestController
@RequestMapping("/api/qz")
public class SSController {
    private final SSService SSService;

    public SSController(SSService SSService) {
        this.SSService = SSService;
    }

    @RequestMapping("addSS")
    public ResponseJson addSS(String title, String content, List<MultipartFile> files, HttpSession session) {
        ResponseJson responseJson;
        if(files == null) {
            responseJson = ResponseJson.createDefaultSuccess(); //没有添加图片
        } else {
            responseJson = SSService.filesUpload(files); // 添加了图片
        }

        if(responseJson.isSuccess()) {
            Shuoshuo shuoshuo = new Shuoshuo();
            shuoshuo.setTitle(title);
            shuoshuo.setContent(content);
            List<String> fileNames = (List<String>) responseJson.getData();
            StringBuilder img = new StringBuilder();
            for(String fileName: fileNames) {
                img.append(Const.IMG_SRC_PRE).append(fileName).append("#");
            }
            shuoshuo.setImg(img.toString());
            shuoshuo.setuId((int) session.getAttribute(Const.CURRENT_USER_ID));
            return SSService.addSS(shuoshuo);
        } else {
            return responseJson;
        }
    }

    @GetMapping("ssList")
    public ResponseJson getSSList(int start, int size) {
        return SSService.getSSList(start,size);
    }

    @GetMapping("ssNextList")
    public ResponseJson getNextSSList(int lastItemId, int start, int size) {
        return SSService.getNextSSList(lastItemId, start, size);
    }

    @GetMapping("uList")
    public ResponseJson getAllListByUId(int uId) {
        return SSService.getAllSSListByUId(uId);
    }

    @DeleteMapping("deleteSS")
    public ResponseJson deleteSS(int id) {
        return SSService.deleteSSById(id);
    }

    @PostMapping("fileUpload")
    public ResponseJson fileUpload(MultipartFile file) {
        return SSService.fileUpload(file);
    }

    @PostMapping("filesUpload")
    public ResponseJson filesUpload(List<MultipartFile> files) {
        return SSService.filesUpload(files);
    }

}
