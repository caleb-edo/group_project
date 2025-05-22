package com.example.controller;

import com.example.model.User;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LeaderboardController {

    @Autowired
    private UserRepository urepo;

    //Controller method to view global leaderboard ranked by number of completed courses
    @GetMapping("/leaderboard")
    public String leaderboard(Model model) {
        List<User> leaderboard = urepo.findFirst5ByOrderByCompletedCourseCountDesc();
        model.addAttribute("leaderboard", leaderboard);
        return "leaderboard/leaderboard";
    }

    //Controller method to view global leaderboard ranked by number of achievements
    @GetMapping("/leaderboard2")
    public String leaderboard2(Model model) {
        List<User> leaderboard = urepo.findFirst5ByOrderByAchievementCountDesc();
        model.addAttribute("leaderboard", leaderboard);
        return "leaderboard/leaderboard2";
    }

}
