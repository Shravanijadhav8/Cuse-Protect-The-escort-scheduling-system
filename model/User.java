package com.shravani.cuseprotect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private String name;
    private String suID;
    private String password;

    public User(String id, String name, String suID, String password) {
        this.id = id;
        this.name = name;
        this.suID = suID;
        this.password = password;
    }

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

    public String getSuID() {
        return suID;
    }

    public void setSuID(String suID) {
        this.suID = suID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "User [id=" + id + ", name=" + name +", suId=" + suID +", password=" + password + "]";
    }

}
