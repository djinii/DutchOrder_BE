package com.dutchOrder.server.model;

import lombok.Data;

@Data
public class CartInfo {
	private int bnum;
    private int osnum;
    private String fname;
    private int fnum;
    private int foption_mikey;
    private int fprice;
    private int osprice;
    private int fcount;
}
