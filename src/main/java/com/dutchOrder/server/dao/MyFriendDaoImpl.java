package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.MyFriend;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyFriendDaoImpl implements MyFriendDao {

	private final SqlSession session;

	@Override
	public MyFriend dataMy(int mnum) {
		MyFriend myData = new MyFriend();
		System.out.println("MyFriendDaoImpl dataMy Start...");
		try {
			myData = session.selectOne("mapMyData", mnum);
			System.out.println("MyFriendDaoImpl dataMy myData -> " + myData.getMnum());
		} catch (Exception e) {
			System.out.println("MyFriendDaoImpl myData Exception -> " + e.getMessage());
		}
		
		return myData;
	}
	
	@Override
	public List<MyFriend> listMyFriend(int mnum) {
		List<MyFriend> myFriendList = null;
		System.out.println("MyFriendDaoImpl listMyFriend Start...");
		try {
			myFriendList = session.selectList("mapMyFriendList", mnum);
			System.out.println("MyFriendDaoImpl listMyFriend myFriendList.size() -> " + myFriendList.size());
		} catch (Exception e) {
			System.out.println("MyFriendDaoImpl myFriendList Exception -> " + e.getMessage());
		}
		
		return myFriendList;
	}

	@Override
	public List<MyFriend> waitMyFriend(int mnum) {
		List<MyFriend> myFriendWait = null;
		System.out.println("MyFriendDaoImpl waitMyFriend Start...");
		try {
			myFriendWait = session.selectList("mapMyFriendWait", mnum);
			System.out.println("MyFriendDaoImpl waitMyFriend myFriendWait.size() -> " + myFriendWait.size());
		} catch (Exception e) {
			System.out.println("MyFriendDaoImpl myFriendWait Exception -> " + e.getMessage());
		}
		
		return myFriendWait;
	}

	@Override
	public MyFriend searchMyFriend(String mnic) {
		MyFriend myFriendSearch = new MyFriend();
		System.out.println("MyFriendDaoImpl searchMyFriend Start...");
		try {
			myFriendSearch = session.selectOne("mapMyFriendSearch", mnic);
			System.out.println("MyFriendDaoImpl searchMyFriend myFriendSearch -> " + myFriendSearch.getMnic());
		} catch (Exception e) {
			System.out.println("MyFriendDaoImpl searchMyFriend Exception -> " + e.getMessage());
		}
		
		return myFriendSearch;
	}

	@Override
	public int friendPlus(MyFriend myFriend) {
		System.out.println("MyFriendDaoImpl friendPlus Start...");
		int plusFriend = 0;
		try {
			plusFriend = session.insert("mapPlusFriend", myFriend);
		} catch (Exception e) {
			System.out.println("MyFriendDaoImpl plusFriend Exception -> " + e.getMessage());
			plusFriend = -1;
		}
		return plusFriend;
	}

	@Override
	public List<MyFriend> myFriendCall(int mnum) {
		List<MyFriend> callMyFriend = null;
		System.out.println("MyFriendDaoImpl callMyFriend Start...");
		try {
			callMyFriend = session.selectList("mapMyFriendCall", mnum);
			System.out.println("MyFriendDaoImpl callMyFriend callMyFriend.size() -> " + callMyFriend.size());
		} catch (Exception e) {
			System.out.println("MyFriendDaoImpl callMyFriend Exception -> " + e.getMessage());
		}
		
		return callMyFriend;
	}

	@Override
	public int updateFriend(MyFriend myFriend) {
		System.out.println("MyFriendDaoImpl updateFriend Start...");
		int friendUpdate = 0;
		try {
			friendUpdate = session.update("mapUpdateFriend", myFriend);
		} catch (Exception e) {
			System.out.println("MyFriendDaoImpl updateFriend Exception -> " + e.getMessage());
		}
		
		return friendUpdate;
	}
}