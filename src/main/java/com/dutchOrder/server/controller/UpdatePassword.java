package com.dutchOrder.server.controller;

// 패스워드 초기화 및 재설정 
public class UpdatePassword {
    private String memail;
    private String newMpw;

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    public String getNewMpw() {
        return newMpw;
    }

    public void setNewMpw(String newMpw) {
        this.newMpw = newMpw;
    }
}
