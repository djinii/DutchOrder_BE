package com.dutchOrder.server.model;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	private int mnum;			// 회원번호
	private int bnum;			// 사업자
	private int onum;			// 주문번호
	
	private String oaddr;		// 배달주소
	private String otel;		// 배달가능 연락처
	private String omsg;		// 요청사항
	private Date odate;			// 주문날짜
	private int ostatus_makey;	// 상태 대분류 800
	private int ostatus_mikey;	// 상태 중분류 
								//	801(장바구니), 802(결제완료후 주문수락 대기), 
								//	803(조리중). 804(배달시작), 805(배달완료)
}