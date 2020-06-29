package com.androidlec.shtalk;

public class Chatting {

    private int pfimage;
    private String name;
    private String lastmsg;


    public Chatting(int pfimage, String name, String lastmsg) {
        this.pfimage = pfimage;
        this.name = name;
        this.lastmsg = lastmsg;
    }


    public int getPfimage() {
        return pfimage;
    }

    public void setPfimage(int pfimage) {
        this.pfimage = pfimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastmsg() {
        return lastmsg;
    }

    public void setLastmsg(String lastmsg) {
        this.lastmsg = lastmsg;
    }
}
