package com.dutchOrder.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.IdClass;

@Entity
@Table(name = "MENU")
@IdClass(MenuId.class)
public class Menu {
    @Id
    private Integer bnum; // 사업자 일련번호
    @Id
    private Integer fnum; // 메뉴 번호

    private String fname; // 메뉴명

    private Integer fprice; // 금액
    private String fimg; // 메뉴이미지
    private String finfo; // 설명
    private Integer foption; // 옵션

    public Integer getBnum() {
        return bnum;
    }

    public void setBnum(Integer bnum) {
        this.bnum = bnum;
    }

    public Integer getFnum() {
        return fnum;
    }

    public void setFnum(Integer fnum) {
        this.fnum = fnum;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getFprice() {
        return fprice;
    }

    public void setFprice(Integer fprice) {
        this.fprice = fprice;
    }

    public String getFimg() {
        return fimg;
    }

    public void setFimg(String fimg) {
        this.fimg = fimg;
    }

    public String getFinfo() {
        return finfo;
    }

    public void setFinfo(String finfo) {
        this.finfo = finfo;
    }

    public Integer getFoption() {
        return foption;
    }

    public void setFoption(Integer foption) {
        this.foption = foption;
    }
}
