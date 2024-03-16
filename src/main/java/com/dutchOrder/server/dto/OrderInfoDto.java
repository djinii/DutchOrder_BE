package com.dutchOrder.server.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderInfoDto {
    private String sname; // Store name
    private Integer onum; // Order number
    private String odate; // Order date
    private List<MenuItemDto> menuItems; // Ordered menu items
    private Integer totalAmount; // Total amount
    private String oaddr; // Order address
    private String omsg; // Special requests (order message)

    public OrderInfoDto(String sname, Integer onum, String odate, List<MenuItemDto> menuItems, Integer totalAmount, String oaddr, String omsg) {
        this.sname = sname;
        this.onum = onum;
        this.odate = odate;
        this.menuItems = menuItems;
        this.totalAmount = totalAmount;
        this.oaddr = oaddr;
        this.omsg = omsg;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOaddr() {
        return oaddr;
    }

    public void setOaddr(String oaddr) {
        this.oaddr = oaddr;
    }

    public String getOmsg() {
        return omsg;
    }

    public void setOmsg(String omsg) {
        this.omsg = omsg;
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

    public List<MenuItemDto> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDto> menuItems) {
        this.menuItems = menuItems;
    }
}
