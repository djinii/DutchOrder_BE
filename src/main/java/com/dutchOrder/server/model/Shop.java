package com.dutchOrder.server.model;

import java.util.List;

import lombok.Data;

@Data
public class Shop {
	private int bnum;		// 사업자 일련번호
	private String saddr;	// 주소
	private String  stel;		// 가게 연락처
	private String sname;	// 상호명
	private String start_time;	// 오픈시간
	private String end_time;	// 마감시간
	private String sstatus_mikey; //영업상황
	private String img1;	// 이미지
	private String img2;	// 이미지
	private String img3;	// 이미지
	
	private int cntLi;		// 리뷰수
	private List<Menu> menuList;
}
