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
	
	@ResponseBody
	@PostMapping("/JH_C_MyFriend")
	public MyFriend clMyData(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clMyData ... ");	
		System.out.println("MyFriendController clMyData myFriend "+myFriend);
		MyFriend dataMy = mfs.dataMy(myFriend.getMnum());
		System.out.println("MyFriendController MyFriend dataMy -> " + dataMy);
		
		return dataMy;
	}
	
	@ResponseBody
	@PostMapping("/JH_C_MyFriendList")
	public List<MyFriend> clMyFriendList(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clMyFriendList ... ");	
		System.out.println("MyFriendController clMyFriendList myFriend "+myFriend);
		List<MyFriend> listMyFriend = mfs.listMyFriend(myFriend.getMnum());
		System.out.println("MyFriendController List listMyFriend.size() -> " + listMyFriend.size());
		
		return listMyFriend;
	}
	
	@ResponseBody
	@PostMapping("/JH_C_MyFriendWait")
	public List<MyFriend> clMyFriendWait(@RequestBody MyFriend myFriend) {
		System.out.println("MyFriendController Start clMyFriendWait ... ");	
		System.out.println("MyFriendController clMyFriendWait myFriend "+myFriend);
		List<MyFriend> waitMyFriend = mfs.waitMyFriend(myFriend.getMnum());
		System.out.println("MyFriendController List waitMyFriend.size() -> " + waitMyFriend.size());
		
		return waitMyFriend;
	}
	
}
