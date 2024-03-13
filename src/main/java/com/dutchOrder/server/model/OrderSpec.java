package com.dutchOrder.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "order_spec")
@IdClass(OrderSpecId.class) // For composite key
public class OrderSpec {

    @Id
    @Column(name = "onum")
    private Integer onum; // 주문 일련번호

    @Id
    @Column(name = "osnum")
    private Integer osnum; // 주문상세 일련번호

    @Column(name = "fnum", nullable = false)
    private Integer fnum; // 메뉴번호

    @Column(name = "foption_makey", nullable = false)
    private Integer foptionMaKey; // 메뉴옵션 대분류

    @Column(name = "foption_mikey", nullable = false)
    private Integer foptionMiKey; // 메뉴옵션 소분류

    @Column(name = "fcount", nullable = false)
    private Integer fcount; // 메뉴수량

    @Column(name = "osprice", nullable = false)
    private Integer osprice; // 메뉴별 금액


    // Constructors, Getters, and Setters
    public OrderSpec() {
    }

    public OrderSpec(Integer onum, Integer osnum, Integer fnum, Integer foptionMaKey, Integer foptionMiKey, Integer fcount, Integer osprice) {
        this.onum = onum;
        this.osnum = osnum;
        this.fnum = fnum;
        this.foptionMaKey = foptionMaKey;
        this.foptionMiKey = foptionMiKey;
        this.fcount = fcount;
        this.osprice = osprice;
    }

    public Integer getFnum() {
        return this.fnum;
    }

    public Integer getFcount() {
        return this.fcount;
    }

    public Integer getOsprice() {
        return this.osprice;
    }
}
