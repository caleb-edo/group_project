package com.example;

import com.example.model.Course;
import com.example.model.Request;
import com.example.model.User;
import com.example.repo.CourseRepository;
import com.example.repo.RequestRepository;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Autowired
    private CourseRepository cRepo;

    @Autowired
    private UserRepository urepo;

    @Autowired
    private RequestRepository rrepo;

    @Override
    public void run(String... args) throws Exception {

//        AchievementManager achievementManager = new AchievementManager();

//
//        Achievement firstLoginAchievement = new Achievement("First Login", "login");
//        Achievement completeLessonAchievement = new Achievement("Complete Lesson", "completeLesson");


//        achievementManager.addAchievement(firstLoginAchievement);
//        achievementManager.addAchievement(completeLessonAchievement);


//        User newUser = new User();
//        newUser.setUsername("username");
//        newUser.setPassword("password");
//// Continue setting other properties of the user as needed
//
//
//        achievementManager.checkAndGiveAchievements(user, "login");
//        achievementManager.checkAndGiveAchievements(user, "completeLesson");


        Course course1 = new Course();
        course1.setCourseName("AI");
        cRepo.save(course1);

        Course course2 = new Course();
        course2.setCourseName("DataScience");
        cRepo.save(course2);

        Course course3 = new Course();
        course3.setCourseName("CloudTechnology");
        cRepo.save(course3);

        Course course4 = new Course();
        course4.setCourseName("CyberThreat");
        cRepo.save(course4);

        Course course5 = new Course();
        course5.setCourseName("Sustainability");
        cRepo.save(course5);

        User u1 = new User();
        u1.setName("Oliver");
        u1.setCompletedCourseCount(1);
        u1.setAchievementCount(3);
        u1 = urepo.save(u1);

        User u2 = new User();
        u2.setName("Myo");
        u2.setCompletedCourseCount(1);
        u2.setAchievementCount(2);
        u2 = urepo.save(u2);

        User u3 = new User();
        u3.setName("John");
        u3.setCompletedCourseCount(3);
        u3.setAchievementCount(2);
        u3 = urepo.save(u3);

        User u4 = new User();
        u4.setName("Doe");
        u4.setCompletedCourseCount(5);
        u4 = urepo.save(u4);

        User u5 = new User();
        u5.setName("Ace");
        u5 = urepo.save(u5);


        u1.setFriends(new ArrayList<>());
        u1.getFriends().add(u4);
        u1 = urepo.save(u1);

        u4.setFriends(new ArrayList<>());
        u4.getFriends().add(u1);
        u4 = urepo.save(u4);

        Request r1 = new Request();
        r1.setSender(u3);
        r1.setReceiver(u1);
        r1.setR_status("Pending");
        r1 = rrepo.save(r1);

        Request r2 = new Request();
        r2.setSender(u2);
        r2.setReceiver(u1);
        r2.setR_status("Pending");
        r2 = rrepo.save(r2);

        u1.setRequests(new ArrayList<>());
        u1.getRequests().add(r1);
        u1.getRequests().add(r2);
        u1 = urepo.save(u1);


    }

}
