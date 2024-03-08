package com.dutchOrder.server.model;

import lombok.Data;

@Data
public class MyFriend {
	private int mnum;					// 회원번호
	private int mfnum;					// 친구 회원번호
	private int mfstatus_makey;		// 대분류 친구상태: 700
	private int mfstatus_mikey;		// 소분류 친구상태: 701(친구요청), 702(수락완료), 703(수락거절)
	private String mnic;					// member table: 닉네임
	private String memail;				// member table: 회원 이메일
}
