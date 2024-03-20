package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.PaymentInfo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MwPaymentDaoImpl implements MwPaymentDao {

	private final SqlSession session;
	
	@Override
	public List<PaymentInfo> getPaymentInfo(int onum) {
		System.out.println("결제다오 결제정보 받아오기 시작...");
		List<PaymentInfo> paymentInfoList = session.selectList("paymentInfoList", onum);
		System.out.println("paymentInfoList의 사이즈: "+paymentInfoList.size());
		return paymentInfoList;
	}

	@Override
	public void payResult(PaymentInfo paymentInfo) {
		System.out.println("다오 결제결과 업데이트 시작...");
		session.update("callUpdatePayDate", paymentInfo);
		
	}

}
