package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.MyFriend;

public interface MyFriendDao {

	MyFriend dataMy(int mnum);

	List<MyFriend> listMyFriend(int mnum);

	List<MyFriend> waitMyFriend(int mnum);

	MyFriend searchMyFriend(String mnic);

	int friendPlus(MyFriend myFriend);

	List<MyFriend> myFriendCall(int mnum);

	int updateFriend(MyFriend myFriend);
	
}
