package com.naver.erp;

public class BoardDTO {
    private int b_no;
    private String writer;
    private String subject;
    private String content;
    private String pwd;
    private String email;
    private String reg_date;
    private int readCount;
    private int group_no;
    private int print_no;
    private int print_level;

    public int getB_no() {
        return b_no;
    }

    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getGroup_no() {
        return group_no;
    }

    public void setGroup_no(int group_no) {
        this.group_no = group_no;
    }

    public int getPrint_no() {
        return print_no;
    }

    public void setPrint_no(int print_no) {
        this.print_no = print_no;
    }

    public int getPrint_level() {
        return print_level;
    }

    public void setPrint_level(int print_level) {
        this.print_level = print_level;
    }
}
