package com.example.tluapp.Entities;

import java.io.Serializable;

public class TimeTable implements Serializable {

    private String subjectName;
    private String time;
    private String location;

    public String getSubjectName() {
        return subjectName;
    }


    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TimeTable(String subjectName, String time, String location) {
        this.subjectName = subjectName;
        this.time = time;
        this.location = location;
    }
}
