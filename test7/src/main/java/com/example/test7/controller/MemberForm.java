package com.example.test7.controller;

public class MemberForm {
    private String name;
    private Long pwd;

    public Long getPwd() {
        return pwd;
    }

    public void setPwd(Long pwd) {
        System.out.println(pwd);
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(name);
        this.name = name;
    }

}
