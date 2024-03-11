package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.MyFriend;
import com.dutchOrder.server.service.MyFriendService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyFriendController {

	private final MyFriendService mfs;
	
	/** 내 닉네임, 이메일 정보 가져오기 */
	@ResponseBody
	@PostMapping("/JH_C_MyFriend")
	public MyFriend clMyData(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clMyData ... ");	
		System.out.println("MyFriendController clMyData myFriend "+myFriend);
		MyFriend dataMy = mfs.dataMy(myFriend.getMnum());
		System.out.println("MyFriendController MyFriend dataMy -> " + dataMy);
		
		return dataMy;
	}
	
	/** 내 친구목록 가져오기 */
	@ResponseBody
	@PostMapping("/JH_C_MyFriendList")
	public List<MyFriend> clMyFriendList(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clMyFriendList ... ");	
		System.out.println("MyFriendController clMyFriendList myFriend "+myFriend);
		List<MyFriend> listMyFriend = mfs.listMyFriend(myFriend.getMnum());
		System.out.println("MyFriendController List listMyFriend.size() -> " + listMyFriend.size());
		
		return listMyFriend;
	}
	
	/** 요청대기중인 친구목록 가져오기 */
	@ResponseBody
	@PostMapping("/JH_C_MyFriendWait")
	public List<MyFriend> clMyFriendWait(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clMyFriendWait ... ");	
		System.out.println("MyFriendController clMyFriendWait myFriend "+myFriend);
		List<MyFriend> waitMyFriend = mfs.waitMyFriend(myFriend.getMnum());
		System.out.println("MyFriendController List waitMyFriend.size() -> " + waitMyFriend.size());
		
		return waitMyFriend;
	}
	
	/** 받은요청 목록가져오기 */
	@ResponseBody
	@PostMapping("/JH_C_MyFriendCall")
	public List<MyFriend> clMyFriendCall(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clMyFriendCall ... ");	
		System.out.println("MyFriendController clMyFriendCall myFriend "+myFriend);
		List<MyFriend> callMyFriend = mfs.callMyFriend(myFriend.getMnum());
		System.out.println("MyFriendController List callMyFriend.size() -> " + callMyFriend.size());
		
		return callMyFriend;
	}
	
	/** 친구 닉네임으로 검색하기 */
	@ResponseBody
	@PostMapping("/JH_C_MyFriendSearch")
	public MyFriend clMyFriendSearch(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clMyFriendSearch ... ");	
		System.out.println("MyFriendController clMyFriendSearch myFriend "+myFriend);
		MyFriend searchMyFriend = mfs.searchMyFriend(myFriend.getMnic());
		System.out.println("MyFriendController List searchMyFriend ->" + searchMyFriend);
		
		return searchMyFriend;
	}
	
	/** 친구 추가하기 버튼클릭 메소드 */
	@ResponseBody
	@PostMapping("/JH_C_PlusFriend")
	public int clPlusFriend(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clPlusFriend...");
		System.out.println("MyFriendController clPlusFriend myFriend "+myFriend);
		int friendPlus = mfs.friendPlus(myFriend);
		System.out.println("MyFriendController clPlusFriend friendPlus-> "+friendPlus);
	
		return friendPlus;
	}
	
	/** 친구 수락, 거절버튼 메소드 */
	@ResponseBody
	@PostMapping("/JH_C_UpdateFriend")
	public int clUpdateFriend(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clUpdateFriend...");
		System.out.println("MyFriendController clUpdateFriend myFriend "+myFriend);
		int updateFriend = mfs.updateFriend(myFriend);
		System.out.println("MyFriendController mfs.clUpdateFriend acceptFriend ->" + updateFriend);
		
		return updateFriend;
	}
	
}
