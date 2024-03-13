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
    private String oAddr; // 배달주소

    @Column(name = "otel", nullable = false)
    private String oTel; // 주문용 연락처

    @Column(name = "omsg")
    private String oMsg; // 요청사항

    @Column(name = "odate")
    private Timestamp oDate; // 주문날짜

    @Column(name = "ostatus_makey", nullable = false)
    private Integer oStatusMaKey; // 상태코드 대분류

    @Column(name = "ostatus_mikey", nullable = false)
    private Integer oStatusMiKey; // 상태코드 중분류

    // Constructors, Getters, and Setters
    public Ordering() {
    }

    public Integer getOStatusMaKey() {
        return this.oStatusMaKey;
    }

    public Integer getOStatusMiKey() {
        return this.oStatusMiKey;
    }

    public Timestamp getODate() {
        return this.oDate;
    }

    public Integer getOnum() {
        return this.onum;
    }

    public String getOAddr() {
        return this.oAddr;
    }
}
