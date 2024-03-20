package com.dutchOrder.server.model;

import java.util.List;

import lombok.Data;

@Data
public class Shop {
	private int 	bnum;				// 사업자 일련번호
	private int 	fcategory_makey;	// 카테고리 대분류 400
 	private int 	fcategory_mikey;	// 카테고리 소분류 301 한식 ...
	private String 	saddr;				// 주소
	private String  stel;				// 가게 연락처
	private String 	sname;				// 상호명
	private String 	start_time;			// 오픈시간
	private String 	end_time;			// 마감시간
	private int 	sstatus_makey;		// 영업상태 대분류 400
	private int 	sstatus_mikey;		// 영업상태 소분류 401 영업중 402 영업종료
	private int 	mnum;				// 회원번호
	private int 	mgroup_mikey;
private String 		bid;				// 사업자 번호
	private int 	bstaus_makey;		// 가게등록상태 대분류 500
	private int	 	bstaus_mikey;		// 가게등록상태 소분류 501 502 503
	private String 	simg1;
	private String	simg2;
	private String 	simg3;
	private String 	sconfirm;			// 승인날짜
	
	private int bfnum;
	private int bftype_makey;
	private int bftype_mikey;
	private String bfimg1;
	private String bfimg2;
	
	private int cntLi;		// 리뷰수
	private List<Menu> menuList;
}
