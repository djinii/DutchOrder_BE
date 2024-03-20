package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MwPaymentDao;
import com.dutchOrder.server.model.PaymentInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MwPaymentServiceImpl implements MwPaymentService {
	
	private final MwPaymentDao paymentDao;

	@Override
	public List<PaymentInfo> getPaymentInfo(int onum) {
		System.out.println("결제서비스 결제정보 받아오기 시작...");
		List<PaymentInfo> paymentInfoList = paymentDao.getPaymentInfo(onum);
		return paymentInfoList;
	}

	@Override
	public void payResult(PaymentInfo paymentInfo) {
		System.out.println("서비스 결제결과 업데이트 시작...");
		paymentDao.payResult(paymentInfo);
		
	}

}
