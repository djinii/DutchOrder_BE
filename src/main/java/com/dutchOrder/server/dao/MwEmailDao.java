package com.dutchOrder.server.dao;

import com.dutchOrder.server.model.EmailModel;

public interface MwEmailDao {

	void ecSave(String email, String eccode);

	int confirmEc(EmailModel mwEmailModel);

}