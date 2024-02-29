package com.dutchOrder.server.model;

import java.util.Date;

import lombok.Data;

@Data
public class Notice {

	private int nonum;			// 공지 번호
	private int mnum;			// (외래키)회원번호
	private String notitle;		// 공지 제목
	private String nocon;		// 공지 내용
	private Date nodate;		// 공지 작성일
	
}
