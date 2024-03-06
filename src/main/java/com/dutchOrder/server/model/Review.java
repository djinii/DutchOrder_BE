package com.dutchOrder.server.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Review {
	private int rnum;				// 리뷰번호
	private int mnum;				// 회원번호
	private int bnum;				// 사업자일련번호
	private int onum;				// 결제일련번호
	private String rcontent;		// 리뷰내용
	private int rstar;				// 별점
	private Timestamp rdate;	// 리뷰작성일
	// Vue3 display 용도
	private String strRdate;		// 리뷰 작성일
	private String rimg;			// 리뷰 이미지
	private int rstatus_makey;  // 리뷰대분류
	private int rstatus_mikey;	// 리뷰소분류(답글작성여부)
	private String rcomment;	// 리뷰답글
	private String mnic; 		// memeber table에서 가져온 mnic

}
