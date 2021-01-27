package com.example.test7.controller;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
// createMemberForm 으로부터 전달받은 데이터를 Controller 로 전달하기 위한 Class
public class MemberForm {
    private String name;
    private String inputEmail;
    private String inputPassword;
    private Date dateTime;
}
