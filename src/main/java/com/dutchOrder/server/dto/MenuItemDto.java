package com.dutchOrder.server.dto;

public class MenuItemDto {
    private Integer fnum; // 메뉴번호
    private String fname; // 메뉴명
    private Integer fcount; // 메뉴수량
    private Integer osprice; // 메뉴별 금액

    // Constructors, Getters, and Setters
    public MenuItemDto() {
    }

    public MenuItemDto(Integer fnum, String fname, Integer fcount, Integer osprice) {
        this.fnum = fnum;
        this.fname = fname;
        this.fcount = fcount;
        this.osprice = osprice;
    }

    // Getters and Setters
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

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public Integer getOsprice() {
        return osprice;
    }

    public void setOsprice(Integer osprice) {
        this.osprice = osprice;
    }
}
