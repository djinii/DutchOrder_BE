package com.dutchOrder.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.sql.Timestamp;

@Entity
@Table(name = "ordering")
@IdClass(OrderingId.class) // For composite key
public class Ordering {

    @Id
    @Column(name = "mnum")
    private Integer mnum; // 회원번호

    @Id
    @Column(name = "bnum")
    private Integer bnum; // 사업자 일련번호

    @Id
    @Column(name = "onum")
    private Integer onum; // 주문 일련번호


    @Column(name = "oaddr", nullable = false)
    private String oaddr; // 배달주소

    @Column(name = "otel", nullable = false)
    private String otel; // 주문용 연락처

    @Column(name = "omsg")
    private String omsg; // 요청사항

    @Column(name = "odate")
    private Timestamp odate; // 주문날짜

    @Column(name = "ostatus_makey", nullable = false)
    private Integer ostatusMaKey; // 상태코드 대분류

    @Column(name = "ostatus_mikey", nullable = false)
    private Integer ostatusMiKey; // 상태코드 중분류

    public Ordering() {
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

    public String getOaddr() {
        return oaddr;
    }

    public void setOaddr(String oAddr) {
        this.oaddr = oAddr;
    }

    public String getOtel() {
        return otel;
    }

    public void setOtel(String oTel) {
        this.otel = oTel;
    }

    public String getOmsg() {
        return omsg;
    }

    public void setOmsg(String omsg) {
        this.omsg = omsg;
    }

    public Timestamp getOdate() {
        return odate;
    }

    public void setOdate(Timestamp odate) {
        this.odate = odate;
    }

    public Integer getOstatusMaKey() {
        return ostatusMaKey;
    }

    public void setOstatusMaKey(Integer ostatusMaKey) {
        this.ostatusMaKey = ostatusMaKey;
    }

    public Integer getOstatusMiKey() {
        return ostatusMiKey;
    }

    public void setOstatusMiKey(Integer ostatusMiKey) {
        this.ostatusMiKey = ostatusMiKey;
    }

}
