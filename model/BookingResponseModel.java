package com.shravani.cuseprotect.model;

public class BookingResponseModel {
    private Integer estimatedTimeInMinutes;
    private Integer numberOfStudentsAhead;

    public Integer getEstimatedTimeInMinutes() {
        return estimatedTimeInMinutes;
    }

    public void setEstimatedTimeInMinutes(Integer estimatedTime) {
        this.estimatedTimeInMinutes = estimatedTime;
    }

    public Integer getNumberOfStudentsAhead() {
        return numberOfStudentsAhead;
    }

    public void setNumberOfStudentsAhead(Integer numberOfStudentsAhead) {
        this.numberOfStudentsAhead = numberOfStudentsAhead;
    }

    public BookingResponseModel(Integer estimatedTime, Integer numberOfStudentsAhead) {
        this.estimatedTimeInMinutes = estimatedTime;
        this.numberOfStudentsAhead = numberOfStudentsAhead;
    }
}
