package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.Notice;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NoticeDaoImpl implements NoticeDao {

	private final SqlSession session;
	
	@Override
	public List<Notice> listNotice(Notice notice) {
		List<Notice> noticeList = null;
		System.out.println("NoticeDaoImpl listNotice Start...");
		try {
			noticeList = session.selectList("mapNoticeList", notice);
			System.out.println("NoticeDaoImpl listNotice noticeList.size() -> " + noticeList.size());
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl NoticeList Exception -> " + e.getMessage());
		}
		
		return noticeList;
	}

	@Override
	public Notice noticeDetail(int nonum) {
		System.out.println("NoticeDaoImpl noticeDetail Start...");
		Notice notice = new Notice();
		try {
			notice = session.selectOne("mapNoticeDetail", nonum);
			System.out.println("NoticeDaoImpl noticeDetail getNotitle -> " + notice.getNotitle());
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl NoticeDetail Exception -> " + e.getMessage());
		}
		
		return notice;
	}

	@Override
	public int writeNotice(Notice notice) {
		System.out.println("NoticeDaoImpl writeNotice Start...");
		int noticeWrite = 0;
		try {
			noticeWrite = session.insert("mapNoticeWrite", notice);
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl writeNotice Exception -> " + e.getMessage());
		}
		
		return noticeWrite;
	}

	@Override
	public int modifyNotice(Notice notice) {
		System.out.println("NoticeDaoImpl modifyNotice Start...");
		int noticeModify = 0;
		try {
			noticeModify = session.update("mapNoticeModify", notice);
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl modifyNotice Exception -> " + e.getMessage());
		}
		
		return noticeModify;
	}

	@Override
	public int deleteNotice(int nonum) {
		System.out.println("NoticeDaoImpl deleteNotice Start...");
		int noticeDelete = 0;
		try {
			noticeDelete = session.delete("mapNoticeDelete", nonum);
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl deleteNotice Exception -> " + e.getMessage());
		}
		
		return noticeDelete;
	}

}
