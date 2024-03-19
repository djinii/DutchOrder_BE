package com.dutchOrder.server.dto;

public class JhMemberDto {
	
	private Long mnum;
	private String mname;
	private String mnic;
	private String mpw;
	private String memail;
	private String mtel;
	
	public Long getMnum() {
		return mnum;
	}
	
	public void setMnum(Long mnum) {
		this.mnum = mnum;
	}
	
	public String getMname() {
		return mname;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public String getMnic() {
		return mnic;
	}
	
	public void setMnic(String mnic) {
		this.mnic = mnic;
	}
	
	public String getMpw() {
		return mpw;
	}
	
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	
	public String getMemail() {
		return memail;
	}
	
	public void setMemail(String memail) {
		this.memail = memail;
	}
	
	public String getMtel() {
		return mtel;
	}
	
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public void setPassword(String newPassword) {
		
	}


}
