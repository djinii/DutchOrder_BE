package com.dutchOrder.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.sql.Timestamp;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @Column(name = "bnum")
    private Integer bnum; // 사업자일련번호

    @Column(name = "fcategory_makey")
    private Integer fcategoryMaKey; // 음식종류 대분류

    @Column(name = "fcategory_mikey")
    private Integer fcategoryMiKey; // 음식종류 중분류

    @Column(name = "saddr")
    private String saddr; // 주소

    @Column(name = "stel")
    private String stel; // 가게연락처

    @Column(name = "sname")
    private String sname; // 상호명

    @Column(name = "start_time")
    private String startTime; // 오픈시간

    @Column(name = "end_time")
    private String endTime; // 마감시간

    @Column(name = "sstatus_makey")
    private Integer sstatusMaKey; // 영업상태 구분 대분류

    @Column(name = "sstatus_mikey")
    private Integer sstatusMiKey; // 영업상태 구분 중분류

    @Column(name = "mnum")
    private Integer mnum; // 회원번호

    @Column(name = "bid")
    private String bid; // 사업자번호

    @Column(name = "bstaus_makey")
    private Integer bstatusMaKey; // 승인여부 상태 대분류

    @Column(name = "bstaus_mikey")
    private Integer bstatusMiKey; // 승인여부 상태 중분류

    @Column(name = "simg1")
    private String simg1; // 이미지1

    @Column(name = "simg2")
    private String simg2; // 이미지2 (null 가능)

    @Column(name = "simg3")
    private String simg3; // 이미지3 (null 가능)

    @Column(name = "sconfirm")
    private Timestamp sconfirm; // 승인 날짜 (null 가능)

    public Shop() {
    }

    // Getters and Setters
    public Integer getBnum() {
        return bnum;
    }

    public void setBnum(Integer bnum) {
        this.bnum = bnum;
    }

    public Integer getFcategoryMaKey() {
        return fcategoryMaKey;
    }

    public void setFcategoryMaKey(Integer fcategoryMaKey) {
        this.fcategoryMaKey = fcategoryMaKey;
    }

    public Integer getFcategoryMiKey() {
        return fcategoryMiKey;
    }

    public void setFcategoryMiKey(Integer fcategoryMiKey) {
        this.fcategoryMiKey = fcategoryMiKey;
    }

    public String getSaddr() {
        return saddr;
    }

    public void setSaddr(String saddr) {
        this.saddr = saddr;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getSstatusMaKey() {
        return sstatusMaKey;
    }

    public void setSstatusMaKey(Integer sstatusMaKey) {
        this.sstatusMaKey = sstatusMaKey;
    }

    public Integer getSstatusMiKey() {
        return sstatusMiKey;
    }

    public void setSstatusMiKey(Integer sstatusMiKey) {
        this.sstatusMiKey = sstatusMiKey;
    }

    public Integer getMnum() {
        return mnum;
    }

    public void setMnum(Integer mnum) {
        this.mnum = mnum;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Integer getBstatusMaKey() {
        return bstatusMaKey;
    }

    public void setBstatusMaKey(Integer bstatusMaKey) {
        this.bstatusMaKey = bstatusMaKey;
    }

    public Integer getBstatusMiKey() {
        return bstatusMiKey;
    }

    public void setBstatusMiKey(Integer bstatusMiKey) {
        this.bstatusMiKey = bstatusMiKey;
    }

    public String getSimg1() {
        return simg1;
    }

    public void setSimg1(String simg1) {
        this.simg1 = simg1;
    }

    public String getSimg2() {
        return simg2;
    }

    public void setSimg2(String simg2) {
        this.simg2 = simg2;
    }

    public String getSimg3() {
        return simg3;
    }

    public void setSimg3(String simg3) {
        this.simg3 = simg3;
    }

    public Timestamp getSconfirm() {
        return sconfirm;
    }

    public void setSconfirm(Timestamp sconfirm) {
        this.sconfirm = sconfirm;
    }
}
