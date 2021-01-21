package com.naver.erp;

public class BoardDTO {
    private String b_no;
    private String writer;
    private String subject;
    private String reg_date;
    private String readCount;
    private String content;
    private String pwd;
    private String email;
    private String group_no;
    private String print_no;
    private String print_level;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getB_no() {
        return b_no;
    }

    public void setB_no(String b_no) {
        this.b_no = b_no;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
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

    public String getGroup_no() {
        return group_no;
    }

    public void setGroup_no(String group_no) {
        this.group_no = group_no;
    }

    public String getPrint_no() {
        return print_no;
    }

    public void setPrint_no(String print_no) {
        this.print_no = print_no;
    }

    public String getPrint_level() {
        return print_level;
    }

    public void setPrint_level(String print_level) {
        this.print_level = print_level;
    }
}
