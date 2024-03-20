package com.dutchOrder.server.model;

import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Member {
	
	@Id
	private 	int 		mnum;
	private 	String 		memail;
	private 	String 		mpw;
	private 	String 		mname;
	private		String		mtel;
	private		String		mnic;
	private		int			mgroup_makey;	// 
	private		int			mgroup_mikey;	// 101 개인 102 사업자 103 관리자 
	private		int			mstatus_makey;	//
	private		int			mstatus_mikey;	// 201 유효회원 202 탈퇴회원 
	private		Date		hiredate;

}