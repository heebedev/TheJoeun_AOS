package com.androidlec.sqlitecrud;

public class Student {

    int id;
    String name;
    String major;
    String pw;

    public Student(int id, String name, String major, String pw) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
