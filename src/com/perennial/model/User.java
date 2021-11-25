package com.perennial.model;

public class User {
    private String username;
    private long usermobile;

    public User(String username, long usermobile) {
        this.username = username;
        this.usermobile = usermobile;
    }

    @Override
    public String toString() {
        return "Name=" + username +
                ", Mobile=" + usermobile +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsename() {
        return username;
    }

    public long getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(long usermobile) {
        this.usermobile = usermobile;
    }


}

