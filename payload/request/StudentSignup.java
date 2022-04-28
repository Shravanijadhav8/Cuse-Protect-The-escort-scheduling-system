package com.shravani.cuseprotect.payload.request;

public class StudentSignup {
    private String id;
    private String name;
    private Integer suID;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSuID() {
        return suID;
    }

    public void setSuID(Integer suID) {
        this.suID = suID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
