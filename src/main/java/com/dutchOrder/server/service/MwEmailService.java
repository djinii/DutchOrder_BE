package com.dutchOrder.server.service;

import com.dutchOrder.server.model.MwEmailModel;

public interface MwEmailService {

	void sendEmail(String email);

	int confirmEc(MwEmailModel mwEmailModel);


}