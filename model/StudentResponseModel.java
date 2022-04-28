package com.shravani.cuseprotect.model;

import java.util.Objects;

public class StudentResponseModel {
    private String name;
    private Integer suID;
    private Integer estimatedTimeInMinutes;
    private Integer numberOfStudentsAhead;
    private String destination;

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

    public Integer getEstimatedTimeInMinutes() {
        return estimatedTimeInMinutes;
    }

    public void setEstimatedTimeInMinutes(Integer estimatedTimeInMinutes) {
        this.estimatedTimeInMinutes = estimatedTimeInMinutes;
    }

    public Integer getNumberOfStudentsAhead() {
        return numberOfStudentsAhead;
    }

    public void setNumberOfStudentsAhead(Integer numberOfStudentsAhead) {
        this.numberOfStudentsAhead = numberOfStudentsAhead;
    }

    public String getLocation() {
        return destination;
    }

    public void setLocation(String destination) {
        this.destination = destination;
    }

    public StudentResponseModel(String name, Integer suID, Integer estimatedTimeInMinutes, Integer numberOfStudentsAhead, String destination) {
        this.name = name;
        this.suID = suID;
        this.estimatedTimeInMinutes = estimatedTimeInMinutes;
        this.numberOfStudentsAhead = numberOfStudentsAhead;
        this.destination = destination;
    }
}
