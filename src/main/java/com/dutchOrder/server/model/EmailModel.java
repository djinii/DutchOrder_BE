package com.dutchOrder.server.model;

import lombok.Data;

@Data
public class EmailModel {
	private int ecnum;
	private String email;
	private String eccode;
	private int verified;
}
