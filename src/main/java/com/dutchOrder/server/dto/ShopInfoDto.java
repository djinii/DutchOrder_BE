package com.dutchOrder.server.dto;

public class ShopInfoDto {
    private String sname;
    private String simg1;
    private String stel;

    // 기본 생성자
    public ShopInfoDto() {
    }

    // 모든 필드를 초기화하는 생성자
    public ShopInfoDto(String sname, String simg1, String stel) {
        this.sname = sname;
        this.simg1 = simg1;
        this.stel = stel;
    }

    // Getter와 Setter
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSimg1() {
        return simg1;
    }

    public void setSimg1(String simg1) {
        this.simg1 = simg1;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }
}
