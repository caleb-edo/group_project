package com.example.model;

public class Achievement {
    private String name;
    private String action;
    private String imagePath; // need to add 

    public Achievement(String name, String action, String imagePath) {
        this.name = name;
        this.action = action;
        this.imagePath = imagePath;
    }

    public Achievement(String name, String action) {
        this.name = name;
        this.action = action;

    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isAchieved(User user, String action) {
        //need to add code to determine if user has earned the achievement
    
        return this.action.equals(action);
    }
}
