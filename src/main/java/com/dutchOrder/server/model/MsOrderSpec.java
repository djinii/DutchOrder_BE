package com.dutchOrder.server.model;

import java.util.Date;

import lombok.Data;

@Data
public class MsOrderSpec {
	private int mnum;
	private int bnum;
	private int onum;
	private String otel;
	private String omsg;
	private Date odate;
	private int ostatus_mikey;
	
	
	private int osnum;
	private int fnum;
	private int osmum;
	
	
	// 메뉴
	private String fname;
}
