package com.shravani.cuseprotect.model;

import org.apache.tomcat.jni.Time;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Location")
public class Location {
    private String location;
    private Integer time;

    public Location(String location, Integer time) {
        this.location = location;
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String toString(){
        return "Location{" + "location='" + location + '\'' + ", time='" + time + '}';
    }
}
