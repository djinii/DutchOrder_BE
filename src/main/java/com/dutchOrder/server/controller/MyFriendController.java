package com.dutchOrder.server.controller;

import org.springframework.stereotype.Controller;

import com.dutchOrder.server.service.MyFriendService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyFriendController {

	private final MyFriendService mfs;
	
}
