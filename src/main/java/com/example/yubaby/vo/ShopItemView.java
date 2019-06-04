package com.example.yubaby.vo;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * Description:
 * Author: Po
 * Date: 2019/5/15 18:23
 **/
public class ShopItemView implements Serializable {
    private Integer id;

    private Integer categoryId;

//    {"id": 1, "username": }
    private Map<String, Object> user;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 价格
     */
    private Double price;

    /**
     * 0 其他 1淘宝 2京东 3苏宁 4唯品会 5当当 6亚马逊 7国美 8网易严选 9网易考拉
     */
//    {id: , name: }
    private Map<String, Object> source;


    /**
     * 链接地址
     */
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Map<String, Object> getUser() {
        return user;
    }

    public void setUser(Map<String, Object> user) {
        this.user = user;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Map<String, Object> getSource() {
        return source;
    }

    public void setSource(Map<String, Object> source) {
        this.source = source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ShopItemView{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", source=" + source +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopItemView)) return false;
        ShopItemView that = (ShopItemView) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCategoryId(), that.getCategoryId()) &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getContent(), that.getContent()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getSource(), that.getSource()) &&
                Objects.equals(getLink(), that.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategoryId(), getUser(), getTitle(), getContent(), getPrice(), getSource(), getLink());
    }
}
