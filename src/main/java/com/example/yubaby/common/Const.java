package com.example.yubaby.common;

import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/9 13:04
 **/
public interface Const {
    String UPLOADED_FOLDER_QZ = "C:\\Users\\Adam\\IdeaProjects\\yubaby\\src\\main\\resources\\static\\img\\";
    String GRAVATAR = "http://www.gravatar.com/avatar/";
    String SALT = "sunGtEYFW59jgfBOeJKqXd7TSML0u36hzbcsun";
    String CURRENT_USER_ACCOUNT = "CURRENT_USER_ACCOUNT";
    String CURRENT_USER_ID = "CURRENT_USER_ID";
    String IMG_SRC_PRE = "http://localhost:8090/img/";
    int PEER_PAGE_LENGTH = 8;

    enum ResponseCode {
        SUCCESS(0, "SUCCESS"),
        ERROR(1, "ERROR");

        private final int code;
        private final String desc;

        ResponseCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}
