package com.androidlec.jsonarray;

public class memberInfo {

    String name;
    int age;
    String[] hobbies;
    int no;
    String id;
    String pw;

    public memberInfo(String name, int age, String[] hobbies, int no, String id, String pw) {
        this.name = name;
        this.age = age;
        this.hobbies= hobbies;
        this.no = no;
        this.id = id;
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
