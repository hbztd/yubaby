package com.example.yubaby.pojo.home;

import java.io.Serializable;

/**
 * bb_change  280天详情
 */
public class BbChange implements Serializable {
    private Integer id;

    /**
     * 当前第几天
     */
    private Integer days;

    /**
     * 宝宝变化
     */
    private String bbDesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getBbDesc() {
        return bbDesc;
    }

    public void setBbDesc(String bbDesc) {
        this.bbDesc = bbDesc;
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
        BbChange other = (BbChange) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getBbDesc() == null ? other.getBbDesc() == null : this.getBbDesc().equals(other.getBbDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getBbDesc() == null) ? 0 : getBbDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", days=").append(days);
        sb.append(", bbDesc=").append(bbDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}