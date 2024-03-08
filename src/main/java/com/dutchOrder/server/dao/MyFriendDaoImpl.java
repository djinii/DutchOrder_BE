package com.dutchOrder.server.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyFriendDaoImpl implements MyFriendDao {

	private final SqlSession session;
	
}
