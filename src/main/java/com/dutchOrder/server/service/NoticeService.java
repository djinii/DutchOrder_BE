package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.model.Notice;

public interface NoticeService {

	List<Notice> listNotice(Notice notice);

	Notice noticeDetail(int nonum);

}
