package com.dutchOrder.server.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Notice {

	private int nonum;			// 공지 번호
	private int mnum;			// (외래키)회원번호
	private String notitle;		// 공지 제목
	private String nocon;		// 공지 내용
	private Timestamp nodate;		// 공지 작성일
	// Vue3 display 용도
	private String strNodate;		// 공지 작성일
	
}