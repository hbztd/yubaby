package com.example.yubaby.pojo.home;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/20 7:25
 **/
@Document("baby_change2")
public class BabyChange2 {
    @Id
    private String id;
    private int month;
    private String mainTitle;
    private String mainContent;
    private List<Map<String, Object>> sub;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int Month) {
        this.month = Month;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public List<Map<String, Object>> getSub() {
        return sub;
    }

    public void setSub(List<Map<String, Object>> sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "BabyChange2{" +
                "id='" + id + '\'' +
                ", week=" + month +
                ", mainTitle='" + mainTitle + '\'' +
                ", mainContent='" + mainContent + '\'' +
                ", sub=" + sub +
                '}';
    }
}
