package com.dutchOrder.server.dao;

import com.dutchOrder.server.model.MwEmailModel;

public interface MwEmailDao {

	void ecSave(String email, String eccode);

	int confirmEc(MwEmailModel mwEmailModel);

}