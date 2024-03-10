package com.dutchOrder.server.service;

import com.dutchOrder.server.model.JhMember;

public interface JhRegisterService {
    void insert(JhMember jhMember);

	boolean checkDuplicates(String mnic);
}
