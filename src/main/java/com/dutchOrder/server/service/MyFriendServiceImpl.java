package com.dutchOrder.server.service;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MyFriendDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyFriendServiceImpl implements MyFriendService {

	private final MyFriendDao mfd;
	
}
