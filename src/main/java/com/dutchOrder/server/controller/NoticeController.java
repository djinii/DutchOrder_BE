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
	
	// 공지사항 리스트 -클라이언트-
	@ResponseBody
	@PostMapping("/JY_C_NoticeList")
	public List<Notice> clNoticeList(@RequestBody Notice notice) {
		System.out.println("NoticeController Start clNoticeList ... ");	
		System.out.println("NoticeController clNoticeList notice "+notice);
		List<Notice> listNotice = ns.listNotice(notice);
		System.out.println("NoticeController List listNotice.size() -> " + listNotice.size());
		
		return listNotice;
	}
	
	// 공지사항 세부내용 -클라이언트-
	@ResponseBody
	@PostMapping("/JY_C_NoticeDetails")
	public Notice clNoticeDetails(@RequestBody Notice notice) {
		System.out.println("NoticeController Start clNoticeDetails...");
		System.out.println("NoticeController clNoticeDetails notice " + notice);
		Notice noticeDetail = ns.noticeDetail(notice.getNonum());
		
		return noticeDetail;
	}

}
