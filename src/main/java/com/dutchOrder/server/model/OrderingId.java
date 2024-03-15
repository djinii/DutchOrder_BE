package com.dutchOrder.server.model;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderingId implements Serializable {
    private Integer mnum;
    private Integer bnum;
    private Integer onum;

    // 기본 생성자
    public OrderingId() {}

    // 모든 필드를 포함하는 생성자
    public OrderingId(Integer mnum, Integer bnum, Integer onum) {
        this.mnum = mnum;
        this.bnum = bnum;
        this.onum = onum;
    }

    public Integer getMnum() {
        return mnum;
    }

    public void setMnum(Integer mnum) {
        this.mnum = mnum;
    }

    public Integer getBnum() {
        return bnum;
    }

    public void setBnum(Integer bnum) {
        this.bnum = bnum;
    }

    public Integer getOnum() {
        return onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }
}
