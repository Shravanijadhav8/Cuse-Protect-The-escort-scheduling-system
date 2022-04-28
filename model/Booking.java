package com.shravani.cuseprotect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bookings")
public class Booking {
    @Id
    private String id;
    private String name;
    private Integer suID;
    private String destination;
    private Integer time;

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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Booking(String id, String name, Integer suID, String destination, Integer time) {
        this.id = id;
        this.name = name;
        this.suID = suID;
        this.destination = destination;
        this.time = time;
    }
}
