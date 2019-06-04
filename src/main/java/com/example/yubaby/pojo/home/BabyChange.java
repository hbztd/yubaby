package com.example.yubaby.pojo.home;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * Description: 40周其他信息
 * Author: Po
 * Date: 2019/5/17 15:57
 **/
@Document("baby_change")
public class BabyChange {
    @Id
    private String id;
    private int week;
    private String mainTitle;
    private String mainContent;
    private List<Map<String, Object>> sub;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
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
        return "BabyChange{" +
                "id='" + id + '\'' +
                ", week=" + week +
                ", mainTitle='" + mainTitle + '\'' +
                ", mainContent='" + mainContent + '\'' +
                ", sub=" + sub +
                '}';
    }
}
