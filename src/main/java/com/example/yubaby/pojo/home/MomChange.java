package com.example.yubaby.pojo.home;

import java.io.Serializable;

/**
 * mom_change
 * @author 
 */
public class MomChange implements Serializable {
    private Integer id;

    /**
     * 当前第几周
     */
    private Integer week;

    /**
     * 标题介绍
     */
    private String momArticle;

    /**
     * 本周概括
     */
    private String content;

    /**
     * 身体变化
     */
    private String bodyChange;

    /**
     * 心理变化
     */
    private String psyChange;

    /**
     * 孕动建议
     */
    private String prmChange;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getMomArticle() {
        return momArticle;
    }

    public void setMomArticle(String momArticle) {
        this.momArticle = momArticle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBodyChange() {
        return bodyChange;
    }

    public void setBodyChange(String bodyChange) {
        this.bodyChange = bodyChange;
    }

    public String getPsyChange() {
        return psyChange;
    }

    public void setPsyChange(String psyChange) {
        this.psyChange = psyChange;
    }

    public String getPrmChange() {
        return prmChange;
    }

    public void setPrmChange(String prmChange) {
        this.prmChange = prmChange;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MomChange other = (MomChange) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWeek() == null ? other.getWeek() == null : this.getWeek().equals(other.getWeek()))
            && (this.getMomArticle() == null ? other.getMomArticle() == null : this.getMomArticle().equals(other.getMomArticle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getBodyChange() == null ? other.getBodyChange() == null : this.getBodyChange().equals(other.getBodyChange()))
            && (this.getPsyChange() == null ? other.getPsyChange() == null : this.getPsyChange().equals(other.getPsyChange()))
            && (this.getPrmChange() == null ? other.getPrmChange() == null : this.getPrmChange().equals(other.getPrmChange()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWeek() == null) ? 0 : getWeek().hashCode());
        result = prime * result + ((getMomArticle() == null) ? 0 : getMomArticle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getBodyChange() == null) ? 0 : getBodyChange().hashCode());
        result = prime * result + ((getPsyChange() == null) ? 0 : getPsyChange().hashCode());
        result = prime * result + ((getPrmChange() == null) ? 0 : getPrmChange().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", week=").append(week);
        sb.append(", momArticle=").append(momArticle);
        sb.append(", content=").append(content);
        sb.append(", bodyChange=").append(bodyChange);
        sb.append(", psyChange=").append(psyChange);
        sb.append(", prmChange=").append(prmChange);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}