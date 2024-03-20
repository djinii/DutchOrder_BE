package com.dutchOrder.server.model;

import java.util.List;

import lombok.Data;

@Data
public class CartReq {
	// POST요청으로 처음 받아와서 저장할 객체
	private List<CartInfo> cart;
    private String oaddr;
    
}
