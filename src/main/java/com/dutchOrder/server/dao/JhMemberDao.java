package com.dutchOrder.server.dao;

import org.apache.ibatis.annotations.Mapper;
import com.dutchOrder.server.model.JhMember;

@Mapper
public interface JhMemberDao {

    JhMember findUserByMemail(String memail);
    
    JhMember findUserByMemailAndMpw(String memail, String mpw);
    
    void save(JhMember jhMember);
}

