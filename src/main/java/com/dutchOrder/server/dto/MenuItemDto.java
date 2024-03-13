package com.dutchOrder.server.dto;

public class MenuItemDto {
    private Integer fnum; // 메뉴번호
    private String fName; // 메뉴명
    private Integer fCount; // 메뉴수량
    private Integer osPrice; // 메뉴별 금액

    // Constructors, Getters, and Setters
    public MenuItemDto() {
    }

    public MenuItemDto(Integer fnum, String fName, Integer fCount, Integer osPrice) {
        this.fnum = fnum;
        this.fName = fName;
        this.fCount = fCount;
        this.osPrice = osPrice;
    }

    // Getters and Setters
    public Integer getFnum() {
        return fnum;
    }

    public void setFnum(Integer fnum) {
        this.fnum = fnum;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public Integer getFCount() {
        return fCount;
    }

    public void setFCount(Integer fCount) {
        this.fCount = fCount;
    }

    public Integer getOsPrice() {
        return osPrice;
    }

    public void setOsPrice(Integer osPrice) {
        this.osPrice = osPrice;
    }
}
