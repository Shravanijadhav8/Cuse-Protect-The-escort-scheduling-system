package com.shravani.cuseprotect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
public class Student {


    @Id // maps id created by mongo, don't insert by yourself. use post first
    private String id;
    private String name;
    private Integer suID;
    private String password;

    public Student(String id, String name, Integer suID, String password) {
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

    public Integer getSuID() {
        return suID;
    }

    public void setSuID(String suID) {
        this.suID = Integer.valueOf(suID);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", suID='" + suID + '\'' + ", password='" + password + '}';
    }
}
