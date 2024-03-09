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
	public List<MyFriend> searchMyFriend(String mnic) {
		List<MyFriend> myFriendSearch = null;
		System.out.println("MyFriendDaoImpl searchMyFriend Start...");
		try {
			myFriendSearch = session.selectList("mapMyFriendSearch", mnic);
			System.out.println("MyFriendDaoImpl searchMyFriend myFriendSearch.size() -> " + myFriendSearch.size());
		} catch (Exception e) {
			System.out.println("MyFriendDaoImpl searchMyFriend Exception -> " + e.getMessage());
		}
		
		return myFriendSearch;
	}
	
}
