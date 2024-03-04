package com.dutchOrder.server.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.MwEmailModel;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MwEmailDaoImpl implements MwEmailDao {

	private final SqlSession session;
	
	@Override
	public void ecSave(String email, String eccode) {
		System.out.println("MwEmailDaoImpl ecSave Start...");
		MwEmailModel emailModel = new MwEmailModel();
		emailModel.setEmail(email);
		emailModel.setEccode(eccode);
		System.out.println("MwEmailDaoImpl ecSave getEmail->"+emailModel.getEmail());
		System.out.println("MwEmailDaoImpl ecSave getEccode->"+emailModel.getEccode());
		session.insert("ecSave", emailModel);
	}

}
