package com.Merlin.hello.model;

public class User {
    private String sno;
    private int sage;
    private String sdept;
    private String sname;
    private char ssex;

    public User(String sno, int sage, String sdept, String sname, char ssex) {
        this.sno = sno;
        this.sage = sage;
        this.sdept = sdept;
        this.sname = sname;
        this.ssex = ssex;
    }

    public User() {

    }


    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getAdept() {
        return sdept;
    }

    public void setAdept(String adept) {
        this.sdept = adept;
    }

    public String getAname() {
        return sname;
    }

    public void setAname(String aname) {
        this.sname = aname;
    }

    public char getSsex() {
        return ssex;
    }

    public void setSsex(char ssex) {
        this.ssex = ssex;
    }
}
