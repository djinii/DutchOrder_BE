package com.dutchOrder.server.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderInfo {
	private int mnum;				// 회원번호
	private int bnum;				// 사업자 일련번호
	private int onum;				// 주문 일련번호
	private String oaddr;			// 배달주소-> 더이상 존재 안함
	private int oadnum;			// 배달주소 고유번호
	private String otel;				// 주문용 연락처
	private String omsg;			// 요청사항
	private Timestamp odate;		// 주문날짜
	// Vue3 display 용도		
	private String strOdate;		// 리뷰 작성일
	private int ostatus_makey;	// 상태코드 대분류: 800
	private int ostatus_mikey; 	// 상태코드 소분류:801=장바구니 / 802=주문수락대기 / 803=조리중 / 804=배달시작 / 805=배달완료
	private String simg1;			// shop table : 가게 이미지
	private String sname;			// shop table : 가게 이름
	private int rnum;					// review table : 리뷰번호
	private int rstatus_makey;	// review table : 답글상태 대분류:1000
	private int rstatus_mikey;		// review table : 답글상태 소분류:1001=답글없음 / 1002=답글있음
	
}
