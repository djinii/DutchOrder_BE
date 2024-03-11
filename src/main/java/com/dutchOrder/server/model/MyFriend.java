package com.dutchOrder.server.model;

import lombok.Data;

@Data
public class MyFriend {
	private int mnum;					// 회원번호
	private int mfnum;					// 친구 회원번호
	private int mfstatus_makey;		// 대분류 친구상태: 700
	private int mfstatus_mikey;		// 소분류 친구상태: 701(친구요청), 702(수락완료), 703(수락거절)
	private int from_id;					// 친구요청한 친구아이디
	private String mnic;					// member table: 닉네임
	private String memail;				// member table: 회원 이메일
	private int mstatus_makey;		// member table: 200(회원상태 분류)
	private int mstatus_mikey; 		// member table: 201(유효회원), 202(탈퇴회원)
}
