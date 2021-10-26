package com.perennial.model;

public class User {
    private String usename;
    private long usermobile;

    @Override
    public String toString() {
        return  "usename=" + usename +
                ", usermobile=" + usermobile +
                '}';
    }

    public String getUsename() {
        return usename;
    }

    public long getUsermobile() {
        return usermobile;
    }

    public User(String usename, long usermobile) {
        this.usename = usename;
        this.usermobile = usermobile;
    }
}

