package com.dutchOrder.server.model;


import lombok.Data;

@Data

public class MsShop {
	private int bnum;
	private int fcategory_makey;
	private int fcategory_mikey;
	private String addr;
	private int stel;
	private String sname;
	private String start_time;
	private String end_time;
	private int sstatus_makey;
	private int sstatus_mikey;

}
