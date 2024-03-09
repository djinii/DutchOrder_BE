package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.MyFriend;

public interface MyFriendDao {

	MyFriend dataMy(int mnum);

	List<MyFriend> listMyFriend(int mnum);

	List<MyFriend> waitMyFriend(int mnum);

	List<MyFriend> searchMyFriend(String mnic);

}
