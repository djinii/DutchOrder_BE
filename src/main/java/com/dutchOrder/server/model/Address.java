package com.dutchOrder.server.model;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class Address {
	private int 	mnum;	// 유저 번호
	private String 	adnum;	
	private String adaddr;  // 주소
	private String adaddr_spec;  // 주소
	private float ad_x;  // 주소 x좌표
	private float ad_y;  // 주소 y좌표
	private Timestamp adLatest_date;
}