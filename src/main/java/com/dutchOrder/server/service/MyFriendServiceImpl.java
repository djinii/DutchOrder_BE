package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MyFriendDao;
import com.dutchOrder.server.model.MyFriend;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyFriendServiceImpl implements MyFriendService {

	private final MyFriendDao mfd;

	@Override
	public MyFriend dataMy(int mnum) {
		MyFriend myData = null;
		System.out.println("MyFriendServiceImpl dataMy Start...");
		System.out.println("MyFriendServiceImpl myData mnum -> " + mnum);
		myData = mfd.dataMy(mnum);
		System.out.println("MyFriendServiceImpl dataMy myData -> " + myData);
		
		return myData;
	}

	@Override
	public List<MyFriend> listMyFriend(int mnum) {
		List<MyFriend> myFriendList = null;
		System.out.println("MyFriendServiceImpl listMyFriend Start...");
		myFriendList = mfd.listMyFriend(mnum);
		System.out.println("MyFriendServiceImpl listMyFriend myFriendList.size() -> " + myFriendList.size());
		
		return myFriendList;
	}

	@Override
	public List<MyFriend> waitMyFriend(int mnum) {
		List<MyFriend> myFriendWait = null;
		System.out.println("MyFriendServiceImpl myFriendWait Start...");
		myFriendWait = mfd.waitMyFriend(mnum);
		System.out.println("MyFriendServiceImpl myFriendWait myFriendWait.size() -> " + myFriendWait.size());
		
		return myFriendWait;
	}

	@Override
	public MyFriend searchMyFriend(String mnic) {
		MyFriend myFriendSearch = null;
		System.out.println("MyFriendServiceImpl searchMyFriend Start...");
		myFriendSearch = mfd.searchMyFriend(mnic);
		System.out.println("MyFriendServiceImpl searchMyFriend myFriendSearch -> " + myFriendSearch);
		
		return myFriendSearch;
	}

	@Override
	public int friendPlus(MyFriend myFriend) {
		int plusFriend = 0;
		System.out.println("MyFriendServiceImpl friendPlus Start...");
		plusFriend = mfd.friendPlus(myFriend);
		
		return plusFriend;
	}

	@Override
	public List<MyFriend> callMyFriend(int mnum) {
		List<MyFriend> myFriendCall = null;
		System.out.println("MyFriendServiceImpl callMyFriend Start...");
		myFriendCall = mfd.myFriendCall(mnum);
		System.out.println("MyFriendServiceImpl callMyFriend myFriendCall.size() -> " + myFriendCall.size());
		
		return myFriendCall;
	}

	@Override
	public int updateFriend(MyFriend myFriend) {
		int friendUpdate = 0;
		System.out.println("MyFriendServiceImpl updateFriend Start...");
		friendUpdate = mfd.updateFriend(myFriend);
		
		return friendUpdate;
	}
	
}