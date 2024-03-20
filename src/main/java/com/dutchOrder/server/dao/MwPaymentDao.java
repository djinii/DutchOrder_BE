package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.PaymentInfo;

public interface MwPaymentDao {

	List<PaymentInfo> getPaymentInfo(int onum);

	void payResult(PaymentInfo paymentInfo);

}
