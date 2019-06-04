package com.example.yubaby.pojo.home;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 19:13
 **/
@Document("knowledge_dir")
public class KnowledgeDir {
    @Id
    private String id;
    @Field("k_id")
    private int kId;
    private String name;
    private List<Map<String, Object>> sub;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getSub() {
        return sub;
    }

    public void setSub(List<Map<String, Object>> sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "KnowledgeDir{" +
                "id='" + id + '\'' +
                ", kId=" + kId +
                ", name='" + name + '\'' +
                ", sub=" + sub +
                '}';
    }
}

