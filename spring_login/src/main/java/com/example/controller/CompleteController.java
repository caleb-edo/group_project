package com.example.controller;

import com.example.model.CompleteCourse;
import com.example.model.Course;
import com.example.model.User;
import com.example.repo.CompleteCourseRepository;
import com.example.repo.CourseRepository;
import com.example.repo.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.example.repo.CompleteCourseRepository;
import jakarta.servlet.http.HttpSession;


import com.example.service.CompleteCourseService;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class CompleteController {
    @Autowired private CompleteCourseRepository crepo;
    @Autowired private CourseRepository courserepo;
    @Autowired private CompleteCourseService completeCourseService; // new field
    @Autowired private UserRepository urepo;
    


    @GetMapping("/quizForm")
    public String quizForm(@RequestParam("courseName") String courseName, Model model){

        Course course = courserepo.findByCourseName(courseName);


        if (course.getStartTime() == null || course.getStartTime().isEmpty()) {
            model.addAttribute("errorMessage", "Sorry, you cannot complete the course at this time. Please ensure that you have started the course before attempting to complete it.");
            return "courses/error";
        }

        model.addAttribute("courseName", courseName);
        return "courses/quiz";



    }

    @PostMapping("/submitQuiz")
    public String submitQuiz(@RequestParam("courseName") String courseName, @RequestParam("answer1") String answer1, @RequestParam("answer2") String answer2, Model model) {


        //Set counter to count the number of collect answers.
        int counter = 0;

        // Receive answers and process them appropriately.
        if ("true1".equals(answer1)) {
            // Increase counter according to the number of correct answers.
            counter++;
        }
        if ("true2".equals(answer2)) {
            counter++;
        }


        // Send course name to jsp file.
        model.addAttribute("courseName", courseName);
        // Send counter to jsp file.
        model.addAttribute("counter", counter);

        
        return "courses/result"; // Display the results page


    }

//    @GetMapping("/initialiseCourses")
//    public String initialiseCourses(Model model) {
//        completeCourseService.incrementClickCount("AI");
//        completeCourseService.incrementClickCount("DataScience");
//        completeCourseService.incrementClickCount("CloudTechnology");
//        completeCourseService.incrementClickCount("CyberThreat");
//        completeCourseService.incrementClickCount("Sustainability");
//
//        // Get the updated click count
//        int clickCount = completeCourseService.getClickCount("AI");
//
//
//
//        // Add the click count to the model
//        model.addAttribute("clickCount", clickCount);
//        System.out.println("Click count: " + clickCount);
//
//        return "courses/topCourses";
//    }

    @GetMapping("/completeAI")
    public String completeAI(Model model, OAuth2AuthenticationToken token, HttpSession session){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = courserepo.findByCourseName("AI");
        LocalDateTime dateTime = LocalDateTime.parse(course.getStartTime(), myTimeFormat);
        Duration duration = Duration.between(dateTime, time1);
        long totalSeconds = duration.toSeconds();
        float totalTime = 0;
        if (course.getTotalTime() != null) {
            totalTime = Float.parseFloat(course.getTotalTime()) + totalSeconds;
        }else {
            totalTime = totalSeconds;
        }
        String endTimeString = time1.format(myTimeFormat);



        // Check if a CompleteCourse object for the "AI" course already exists in the repository
        CompleteCourse completeCourse = crepo.findByCourseName("AI");
        if (completeCourse == null) {
            // If it does not exist, create a new CompleteCourse object
            completeCourse = new CompleteCourse();
            completeCourse.setCourseName(course.getCourseName());
        }

        // Update the necessary fields of the CompleteCourse object
        completeCourse.setEndTime(endTimeString);
        completeCourse.setTotalTime(String.valueOf(totalTime));
        course.setTotalTime(String.valueOf(totalTime));

        // Increment the click count for the course
        completeCourseService.incrementClickCount("AI");

        // Get the updated click count
        int clickCount = completeCourseService.getClickCount("AI");
        if (clickCount == 0) {
            clickCount = 1;

        }


        // Add the click count to the model
        completeCourse.setClickCount(clickCount);
        model.addAttribute("clickCount", clickCount);
        System.out.println("Click count: " + clickCount);


        // Save the updated CompleteCourse object back to the repository
        courserepo.save(course);
        crepo.save(completeCourse);

        model.addAttribute("completedCourse", crepo.findByCourseName("AI"));
        model.addAttribute("time", crepo.findByCourseName("AI").getTotalTime());
        
        

        // Finder user, increment completed course count, save user back to repository
        User user = urepo.findByName((String) token.getPrincipal().getAttributes().get("given_name"));
        user.setCompletedCourseCount(user.getCompletedCourseCount()+1);
        user = urepo.save(user);

        Integer completedCourses = (Integer) session.getAttribute("completedCourses");
        if (completedCourses == null) {
            completedCourses = 0;
        }
        completedCourses++;
        session.setAttribute("completedCourses", completedCourses);
        int coinsEarned = completedCourses * 50;
        session.setAttribute("coinsEarned", coinsEarned); // Set coinsEarned in session
        model.addAttribute("coinsEarned", coinsEarned);


        return "courses/finishedCourse";
    }


    @GetMapping("/completeDataScience")
    public String completeDataScience(Model model, OAuth2AuthenticationToken token, HttpSession session){
//        CompleteCourse completeCourse = new CompleteCourse();
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = courserepo.findByCourseName("DataScience");
        LocalDateTime dateTime = LocalDateTime.parse(course.getStartTime(), myTimeFormat);
        Duration duration = Duration.between(dateTime, time1);
        long totalSeconds = duration.toSeconds();
        float totalTime = 0;
        if (course.getTotalTime() != null) {
            totalTime = Float.parseFloat(course.getTotalTime()) + totalSeconds;
        }else {
            totalTime = totalSeconds;
        }
        String endTimeString = time1.format(myTimeFormat);

        // Check if a CompleteCourse object for the "datascience" course already exists in the repository
        CompleteCourse completeCourse = crepo.findByCourseName("DataScience");
        if (completeCourse == null) {
            // If it does not exist, create a new CompleteCourse object
            completeCourse = new CompleteCourse();
            completeCourse.setCourseName(course.getCourseName());
        }

        // Update the necessary fields of the CompleteCourse object
        completeCourse.setEndTime(endTimeString);
        completeCourse.setTotalTime(String.valueOf(totalTime));
        completeCourse.setCourseName(course.getCourseName());
        course.setTotalTime(String.valueOf(totalTime));

        // Increment the click count for the course
        completeCourseService.incrementClickCount("DataScience");

        // Get the updated click count
        int clickCount = completeCourseService.getClickCount("DataScience");
        if (clickCount == 0) {
            clickCount = 1;

        }


        // Add the click count to the model
        completeCourse.setClickCount(clickCount);
        model.addAttribute("clickCount", clickCount);
        System.out.println("Click count: " + clickCount);

        courserepo.save(course);
        crepo.save(completeCourse);
        model.addAttribute("completedCourse", crepo.findByCourseName("DataScience"));
        model.addAttribute("time", crepo.findByCourseName("DataScience").getTotalTime());
        

        // Finder user, increment completed course count, save user back to repository
        User user = urepo.findByName((String) token.getPrincipal().getAttributes().get("given_name"));
        user.setCompletedCourseCount(user.getCompletedCourseCount()+1);
        user = urepo.save(user);

        Integer completedCourses = (Integer) session.getAttribute("completedCourses");
        if (completedCourses == null) {
            completedCourses = 0;
        }
        completedCourses++;
        session.setAttribute("completedCourses", completedCourses);
        int coinsEarned = completedCourses * 50;
        session.setAttribute("coinsEarned", coinsEarned); // Set coinsEarned in session
        model.addAttribute("coinsEarned", coinsEarned);

        return "courses/finishedCourse";
    }
    @GetMapping("/completeCloudTechnology")
    public String completeCloudTechnology(Model model, OAuth2AuthenticationToken token, HttpSession session){
//        CompleteCourse completeCourse = new CompleteCourse();
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = courserepo.findByCourseName("CloudTechnology");
        LocalDateTime dateTime = LocalDateTime.parse(course.getStartTime(), myTimeFormat);
        Duration duration = Duration.between(dateTime, time1);
        long totalSeconds = duration.toSeconds();
        float totalTime = 0;
        if (course.getTotalTime() != null) {
            totalTime = Float.parseFloat(course.getTotalTime()) + totalSeconds;
        }else {
            totalTime = totalSeconds;
        }
        String endTimeString = time1.format(myTimeFormat);

        // Check if a CompleteCourse object for the "datascience" course already exists in the repository
        CompleteCourse completeCourse = crepo.findByCourseName("CloudTechnology");
        if (completeCourse == null) {
            // If it does not exist, create a new CompleteCourse object
            completeCourse = new CompleteCourse();
            completeCourse.setCourseName(course.getCourseName());
        }

        completeCourse.setEndTime(endTimeString);
        completeCourse.setTotalTime(String.valueOf(totalTime));
        completeCourse.setCourseName(course.getCourseName());
        course.setTotalTime(String.valueOf(totalTime));

        // Increment the click count for the course
        completeCourseService.incrementClickCount("CloudTechnology");

        // Get the updated click count
        int clickCount = completeCourseService.getClickCount("CloudTechnology");
        System.out.println("Click count: " + clickCount);
        if (clickCount == 0) {
            clickCount = 1;

        }


        // Add the click count to the model
        System.out.println("new Click count: " + clickCount);
        completeCourse.setClickCount(clickCount);
        model.addAttribute("clickCount", clickCount);


        courserepo.save(course);
        crepo.save(completeCourse);
        model.addAttribute("completedCourse", crepo.findByCourseName("CloudTechnology"));
        model.addAttribute("time", crepo.findByCourseName("CloudTechnology").getTotalTime());
        

        // Finder user, increment completed course count, save user back to repository
        User user = urepo.findByName((String) token.getPrincipal().getAttributes().get("given_name"));
        user.setCompletedCourseCount(user.getCompletedCourseCount()+1);
        user = urepo.save(user);

        Integer completedCourses = (Integer) session.getAttribute("completedCourses");
        if (completedCourses == null) {
            completedCourses = 0;
        }
        completedCourses++;
        session.setAttribute("completedCourses", completedCourses);
        int coinsEarned = completedCourses * 50;
        session.setAttribute("coinsEarned", coinsEarned); // Set coinsEarned in session
        model.addAttribute("coinsEarned", coinsEarned);

        return "courses/finishedCourse";
    }


    @GetMapping("/completeCyberThreat")
    public String completeCyberThreat(Model model, OAuth2AuthenticationToken token, HttpSession session){
//        CompleteCourse completeCourse = new CompleteCourse();
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = courserepo.findByCourseName("CyberThreat");
        LocalDateTime dateTime = LocalDateTime.parse(course.getStartTime(), myTimeFormat);
        Duration duration = Duration.between(dateTime, time1);
        long totalSeconds = duration.toSeconds();
        float totalTime = 0;
        if (course.getTotalTime() != null) {
            totalTime = Float.parseFloat(course.getTotalTime()) + totalSeconds;
        }else {
            totalTime = totalSeconds;
        }
        String endTimeString = time1.format(myTimeFormat);

        // Check if a CompleteCourse object for the "datascience" course already exists in the repository
        CompleteCourse completeCourse = crepo.findByCourseName("CyberThreat");
        if (completeCourse == null) {
            // If it does not exist, create a new CompleteCourse object
            completeCourse = new CompleteCourse();
            completeCourse.setCourseName(course.getCourseName());
        }

        completeCourse.setEndTime(endTimeString);
        completeCourse.setTotalTime(String.valueOf(totalTime));
        completeCourse.setCourseName(course.getCourseName());
        course.setTotalTime(String.valueOf(totalTime));

        // Increment the click count for the course
        completeCourseService.incrementClickCount("CyberThreat");

        // Get the updated click count
        int clickCount = completeCourseService.getClickCount("CyberThreat");
        if (clickCount == 0) {
            clickCount = 1;

        }


        // Add the click count to the model
        completeCourse.setClickCount(clickCount);
        model.addAttribute("clickCount", clickCount);
        System.out.println("Click count: " + clickCount);

        courserepo.save(course);
        crepo.save(completeCourse);
        model.addAttribute("completedCourse", crepo.findByCourseName("CyberThreat"));
        model.addAttribute("time", crepo.findByCourseName("CyberThreat").getTotalTime());
        

        // Finder user, increment completed course count, save user back to repository
        User user = urepo.findByName((String) token.getPrincipal().getAttributes().get("given_name"));
        user.setCompletedCourseCount(user.getCompletedCourseCount()+1);
        user = urepo.save(user);

        Integer completedCourses = (Integer) session.getAttribute("completedCourses");
        if (completedCourses == null) {
            completedCourses = 0;
        }
        completedCourses++;
        session.setAttribute("completedCourses", completedCourses);
        int coinsEarned = completedCourses * 50;
        session.setAttribute("coinsEarned", coinsEarned); // Set coinsEarned in session
        model.addAttribute("coinsEarned", coinsEarned);

        return "courses/finishedCourse";
    }
    @GetMapping("/completeSustainability")
    public String completeSustainability(Model model, OAuth2AuthenticationToken token, HttpSession session){
//        CompleteCourse completeCourse = new CompleteCourse();
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = courserepo.findByCourseName("Sustainability");
        LocalDateTime dateTime = LocalDateTime.parse(course.getStartTime(), myTimeFormat);
        Duration duration = Duration.between(dateTime, time1);
        long totalSeconds = duration.toSeconds();
        float totalTime = 0;
        if (course.getTotalTime() != null) {
            totalTime = Float.parseFloat(course.getTotalTime()) + totalSeconds;
        }else {
            totalTime = totalSeconds;
        }
        String endTimeString = time1.format(myTimeFormat);

        // Check if a CompleteCourse object for the "datascience" course already exists in the repository
        CompleteCourse completeCourse = crepo.findByCourseName("Sustainability");
        if (completeCourse == null) {
            // If it does not exist, create a new CompleteCourse object
            completeCourse = new CompleteCourse();
            completeCourse.setCourseName(course.getCourseName());
        }

        completeCourse.setEndTime(endTimeString);
        completeCourse.setTotalTime(String.valueOf(totalTime));
        completeCourse.setCourseName(course.getCourseName());
        course.setTotalTime(String.valueOf(totalTime));


        // Increment the click count for the course
        completeCourseService.incrementClickCount("Sustainability");

        // Get the updated click count
        int clickCount = completeCourseService.getClickCount("Sustainability");
        if (clickCount == 0) {
            clickCount = 1;

        }

        // Add the click count to the model
        completeCourse.setClickCount(clickCount);
        model.addAttribute("clickCount", clickCount);
        System.out.println("Click count: " + clickCount);

        courserepo.save(course);
        crepo.save(completeCourse);
        model.addAttribute("completedCourse", crepo.findByCourseName("Sustainability"));
        model.addAttribute("time", crepo.findByCourseName("Sustainability").getTotalTime());
       

        // Finder user, increment completed course count, save user back to repository
        User user = urepo.findByName((String) token.getPrincipal().getAttributes().get("given_name"));
        user.setCompletedCourseCount(user.getCompletedCourseCount()+1);
        user = urepo.save(user);

        Integer completedCourses = (Integer) session.getAttribute("completedCourses");
        if (completedCourses == null) {
            completedCourses = 0;
        }
        completedCourses++;
        session.setAttribute("completedCourses", completedCourses);
        int coinsEarned = completedCourses * 50;
        session.setAttribute("coinsEarned", coinsEarned); // Set coinsEarned in session
        model.addAttribute("coinsEarned", coinsEarned);

        return "courses/finishedCourse";
    }

}

