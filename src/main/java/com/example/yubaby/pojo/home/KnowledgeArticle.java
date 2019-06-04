package com.example.yubaby.pojo.home;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/18 19:09
 **/
@Document("knowledge_article")
public class KnowledgeArticle {
    @Id
    private String id;
    @Field("a_id")
    private int aId;
    private String title;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "KnowledgeArticle{" +
                "id='" + id + '\'' +
                ", aId='" + aId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
