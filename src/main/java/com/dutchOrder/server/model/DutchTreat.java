package com.dutchOrder.server.model;

import lombok.Data;

@Data
public class DutchTreat {
	
	private int onum;
	private String dpmem;
	private int dpprice;
	private int dpstatus_makey;
	private int dpstatus_mikey;

	private int mnum;
	private String memail;
	private String mname;
	private String mtel;
}
