package com.dutchOrder.server.dto;

import java.util.List;

public class OrderDetailsDto {
    private String oDate; // 주문날짜
    private Integer onum; // 주문 일련번호
    private String oStatus; // 주문상태
    private List<MenuItemDto> menuItems; // 메뉴 아이템 리스트
    private Integer totalAmount; // 총 금액
    private String oAddr; // 배달주소

    // Constructors
    public OrderDetailsDto() {
    }

    public OrderDetailsDto(String oDate, Integer onum, String oStatus, List<MenuItemDto> menuItems, Integer totalAmount, String oAddr) {
        this.oDate = oDate;
        this.onum = onum;
        this.oStatus = oStatus;
        this.menuItems = menuItems;
        this.totalAmount = totalAmount;
        this.oAddr = oAddr;
    }

    // Getters and Setters
    public String getODate() {
        return oDate;
    }

    public void setODate(String oDate) {
        this.oDate = oDate;
    }

    public Integer getOnum() {
        return onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }

    public String getOStatus() {
        return oStatus;
    }

    public void setOStatus(String oStatus) {
        this.oStatus = oStatus;
    }

    public List<MenuItemDto> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDto> menuItems) {
        this.menuItems = menuItems;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOAddr() {
        return oAddr;
    }

    public void setOAddr(String oAddr) {
        this.oAddr = oAddr;
    }
}
