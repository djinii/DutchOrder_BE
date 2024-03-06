package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.Notice;
import com.dutchOrder.server.service.NoticeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeService ns;
	
	/** 공지사항 리스트 불러오기 -클라이언트- */
	@ResponseBody
	@PostMapping("/JY_C_NoticeList")
	public List<Notice> clNoticeList(@RequestBody Notice notice) {
		System.out.println("NoticeController Start clNoticeList ... ");	
		System.out.println("NoticeController clNoticeList notice "+notice);
		List<Notice> listNotice = ns.listNotice(notice);
		System.out.println("NoticeController List listNotice.size() -> " + listNotice.size());
		
		return listNotice;
	}
	
	/** 공지사항 세부내용 -클라이언트- */
	@ResponseBody
	@PostMapping("/JY_C_NoticeDetails")
	public Notice clNoticeDetails(@RequestBody Notice notice) {
		System.out.println("NoticeController Start clNoticeDetails...");
		System.out.println("NoticeController clNoticeDetails notice " + notice);
		Notice noticeDetail = ns.noticeDetail(notice.getNonum());
		System.out.println("NoticeController clNoticeDetails noticeDetail -> " + noticeDetail);
		
		return noticeDetail;
	}
	
	/** 공지사항 리스트 불러오기 -관리자- */
		@ResponseBody
		@PostMapping("/JY_A_NoticeList")
		public List<Notice> adNoticeList(@RequestBody Notice notice) {
			System.out.println("NoticeController Start adNoticeList ... ");	
			System.out.println("NoticeController adNoticeList notice "+notice);
			List<Notice> listNotice = ns.listNotice(notice);
			System.out.println("NoticeController List listNotice.size() -> " + listNotice.size());
			
			return listNotice;
		}
		
		/** 공지사항 세부내용 -관리자- */
		@ResponseBody
		@PostMapping("/JY_A_NoticeDetails")
		public Notice adNoticeDetails(@RequestBody Notice notice) {
			System.out.println("NoticeController Start adNoticeDetails...");
			System.out.println("NoticeController adNoticeDetails notice " + notice);
			Notice noticeDetail = ns.noticeDetail(notice.getNonum());
			
			return noticeDetail;
		}
		
		/** 공지사항 작성 -관리자- */
		@ResponseBody
		@PostMapping("/JY_A_NoticeWrite")
		public int adNoticeWrite(@RequestBody Notice notice) {
			System.out.println("NoticeController Start adNoticeWrite...");
			System.out.println("NoticeCOntroller adNoticeWrite notice " + notice);
			int writeNotice = ns.writeNotice(notice);
			
			return writeNotice;
		}
		
		/** 공지사항 수정 -관리자- */
		@ResponseBody
		@PostMapping("/JY_A_NoticeModify")
		public int adNoticeModify(@RequestBody Notice notice) {
			System.out.println("NoticeController Start adNoticeModify");
			System.out.println("NoticeController adNoticeModify notice " + notice);
			int modifyNotice = ns.modifyNotice(notice);
			System.out.println("NoticeController ns.modifyNotice modifyNotice -> " + modifyNotice);
			
			return modifyNotice;
		}
		
		/** 공지사항 삭제 -관리자- */
		@ResponseBody
		@PostMapping("/JY_A_NoticeDelete")
		public int adNoticeDelete(@RequestBody Notice notice) {
			System.out.println("NoticeController Start adNoticeDelete");
			System.out.println("NoticeController adNoticeDelete notice " + notice);
			int deleteNotice = ns.deleteNotice(notice.getNonum());
			
			return deleteNotice;
		}

}
