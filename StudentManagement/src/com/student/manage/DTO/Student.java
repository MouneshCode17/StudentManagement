package com.student.manage.DTO;

public class Student {
    private String sid;
    private String sname;
    private String sadd;

    public String getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getSadd() {
        return sadd;
    }

    public void setSadd(String sadd) {
        this.sadd = sadd;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
