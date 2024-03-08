package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MyFriendDao;
import com.dutchOrder.server.model.MyFriend;
import com.dutchOrder.server.model.Review;

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
	
}
