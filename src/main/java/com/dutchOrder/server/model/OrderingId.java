package com.dutchOrder.server.model;

import java.io.Serializable;

public class OrderingId implements Serializable {
    private Integer mnum; // 회원번호
    private Integer bnum; // 사업자 일련번호
    private Integer onum; // 주문 일련번호

    public OrderingId() {
    }
}
