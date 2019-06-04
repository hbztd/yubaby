package com.example.yubaby.pojo.home;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/17 8:49
 **/
@Document("dir_article")
public class DirArticle {
    @Id
    private String id;
    @Field("k_id")
    private int kId;
    @Field("s_id")
    private int sId;
    private List<Integer> item;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getkId() {
        return kId;
    }

    public void setkId(int kId) {
        this.kId = kId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public List<Integer> getItem() {
        return item;
    }

    public void setItem(List<Integer> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "DirArticle{" +
                "id='" + id + '\'' +
                ", kId=" + kId +
                ", sId=" + sId +
                ", item=" + item +
                '}';
    }
}
