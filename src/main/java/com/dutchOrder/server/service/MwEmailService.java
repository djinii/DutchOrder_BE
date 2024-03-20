package com.dutchOrder.server.service;

import com.dutchOrder.server.model.EmailModel;

public interface MwEmailService {

	void sendEmail(String email);

	int confirmEc(EmailModel mwEmailModel);


}