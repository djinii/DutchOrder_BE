package com.dutchOrder.server.model;


import lombok.Data;

@Data

public class MsShop {
	private int bnum;   // 사업자 번호
	private int fcategory_makey;	// 카테고리 대분류 400
 	private int fcategory_mikey;	// 카테고리 소분류 301 한식 ...
	private String saddr;			// 주소
	private String stel;			// 전화번호
	private String sname;			// 가게명
	private String start_time;		// 운영시작시간
	private String end_time;		// 운영종료시간
	private int sstatus_makey;		// 영업상태 대분류 400
	private int sstatus_mikey;		// 영업상태 소분류 401 영업중 402 영업종료
	private int mnum;				// 회원번호
	private int mgroup_mikey;
	private String bid;				// 사업자 번호
	private int bstaus_makey;		// 가게등록상태 대분류 500
	private int bstaus_mikey;		// 가게등록상태 소분류 501 502 503
	private String simg1;
	private String simg2;
	private String simg3;
	private String sconfirm;
	
	private int bfnum;
	private int bftype_makey;
	private int bftype_mikey;
	private String bfimg1;
	private String bfimg2;

}