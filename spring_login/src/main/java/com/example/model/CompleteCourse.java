package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CompleteCourse {
    @Id
    private String courseName;

    private String endTime;

    private String totalTime;

    private int clickCount;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public String toString() {
        return "CompleteCourse{" +
                "courseName='" + courseName + '\'' +
                ", endTime='" + endTime + '\'' +
                ", totalTime='" + totalTime + '\'' +
                '}';
    }
}
