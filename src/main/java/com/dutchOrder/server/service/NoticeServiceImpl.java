package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.NoticeDao;
import com.dutchOrder.server.model.Notice;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeDao nd;

	@Override
	public List<Notice> listNotice(Notice notice) {
		List<Notice> noticeList = null;
		System.out.println("NoticeServiceImpl listManager Start...");
		noticeList = nd.listNotice(notice);
		System.out.println("NoticeServiceImpl listNotice noticeList.size() -> " + noticeList.size());
		
		return noticeList;
	}

	@Override
	public Notice noticeDetail(int nonum) {
		Notice notice = null;
		System.out.println("NoticeServiceImpl noticeDetail Start...");
		System.out.println("NoticeServiceImpl noticeDetail nonum -> " + nonum);
		notice = nd.noticeDetail(nonum);
		System.out.println("NoticeServeImpl noticeDetail notice -> " + notice);
		
		return notice;
	}

	@Override
	public int writeNotice(Notice notice) {
		int noticeWrite = 0;
		System.out.println("NoticeServiceImpl writeNotice Start...");
		noticeWrite = nd.writeNotice(notice);
		
		return noticeWrite;
	}

	@Override
	public int modifyNotice(Notice notice) {
		int noticeModify = 0;
		System.out.println("NoticeServiceImpl noticeModify Start...");
		noticeModify= nd.modifyNotice(notice);
		
		return noticeModify;
	}

}
