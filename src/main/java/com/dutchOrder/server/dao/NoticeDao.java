package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.Notice;

public interface NoticeDao {

	List<Notice> listNotice(Notice notice);

	Notice noticeDetail(int nonum);

	int writeNotice(Notice notice);

	int modifyNotice(Notice notice);

}
