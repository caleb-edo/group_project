package com.example.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    //this is the course table, keeping track of users time spent on an IBM course
    @Id
    private String courseName;
    private String startTime;
    private String pausedTime;
    private String totalTime = "0";

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + pausedTime + '\'' +
                ", totalTime='" + totalTime + '\'' +
                '}';
    }

    public String getPausedTime() {
        return pausedTime;
    }

    public void setPausedTime(String pausedTime) {
        this.pausedTime = pausedTime;
    }
}
