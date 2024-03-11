package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.MyFriend;

public interface MyFriendService {

	MyFriend dataMy(int mnum);

	List<MyFriend> listMyFriend(int mnum);

	List<MyFriend> waitMyFriend(int mnum);

	MyFriend searchMyFriend(String mnic);

	int friendPlus(MyFriend myFriend);

	List<MyFriend> callMyFriend(int mnum);

	int updateFriend(MyFriend myFriend);

}
