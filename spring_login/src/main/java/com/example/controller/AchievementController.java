package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AchievementController {

    @GetMapping("/refreshAchievements")
    public ModelAndView showAchievements() {
        
        String achievementName = "First Login";
//        String achievementImagePath = "/images/first_login.jpg";
        
        // Prepare the model and view
        ModelAndView modelAndView = new ModelAndView("achievements");
        modelAndView.addObject("achievementName", achievementName);
//        modelAndView.addObject("achievementImagePath", achievementImagePath);
        return modelAndView;

    }

    @GetMapping("/achievements")
    public String achievements() {
        return "achievementPage";
    }
}
