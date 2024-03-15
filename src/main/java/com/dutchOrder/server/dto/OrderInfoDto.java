package com.dutchOrder.server.dto;

import java.time.LocalDateTime;

public class OrderInfoDto {
    private String sname;
    private Integer onum;
    private String odate;

    public OrderInfoDto(String sname, Integer onum, String odate) {
        this.sname = sname;
        this.onum = onum;
        this.odate = odate;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getOnum() {
        return onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }
}
