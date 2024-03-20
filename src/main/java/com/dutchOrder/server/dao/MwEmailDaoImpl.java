package com.dutchOrder.server.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.EmailModel;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MwEmailDaoImpl implements MwEmailDao {

	private final SqlSession session;
	
	@Override
	public void ecSave(String email, String eccode) {
		System.out.println("MwEmailDaoImpl ecSave Start...");
		EmailModel emailModel = new EmailModel();
		emailModel.setEmail(email);
		emailModel.setEccode(eccode);
		System.out.println("MwEmailDaoImpl ecSave getEmail->"+emailModel.getEmail());
		System.out.println("MwEmailDaoImpl ecSave getEccode->"+emailModel.getEccode());
		session.insert("ecSave", emailModel);
	}

	@Override
	public int confirmEc(EmailModel mwEmailModel) {
		System.out.println("MwEmailDaoImpl confirmEc Start...");
		int result = 0;
		String email = mwEmailModel.getEmail();
		String eccode = mwEmailModel.getEccode();
		System.out.println("MwEmailDaoImpl confirmEc getEmail->"+email);
		System.out.println("MwEmailDaoImpl confirmEc getEccode->"+eccode);
		result = session.update("confirmEc", mwEmailModel);
		System.out.println("MwEmailDaoImpl confirmEc result-->"+result);
		
		return result;
	}

}