package com.example.controller;

import com.example.ProjectApplication;
//import com.example.project.model.Student;
import com.example.model.CompleteCourse;
import com.example.model.Course;
import com.example.repo.CompleteCourseRepository;
import com.example.repo.CourseRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.repo.CourseRepository;
import com.example.service.CompleteCourseService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CoursesController {


    private final CourseRepository cRepo;
    private final CompleteCourseService completeCourseService;
    private final CompleteCourseRepository completeCourseRepository;


    @Autowired
    public CoursesController(CompleteCourseRepository completeCourseRepository, CourseRepository cRepo, CompleteCourseService completeCourseService) {
        this.completeCourseRepository = completeCourseRepository;
        this.cRepo = cRepo;
        this.completeCourseService = completeCourseService;
    }

//    public CoursesController(CourseRepository cRepo) {
//        this.cRepo = cRepo;
//    }

//    @Autowired
//    public CoursesController(CourseRepository cRepo, CompleteCourseService completeCourseService) {
//        this.cRepo = cRepo;
//        this.completeCourseService = completeCourseService;
//    }

    @GetMapping("/courses")
    public String courses(Model model, HttpSession session) {
        //model.addAttribute("courses", ProjectApplication.courses);

        // Get the click count for the course
//        int clickCount = this.completeCourseService.getClickCount("AI");

        // Add the click count to the model
//        model.addAttribute("clickCount", clickCount);

        Map<String, Integer> clickCounts = new HashMap<>();
        clickCounts.put("AI", completeCourseService.getClickCount("AI"));
        clickCounts.put("DataScience", completeCourseService.getClickCount("DataScience"));
        clickCounts.put("CloudTechnology", completeCourseService.getClickCount("CloudTechnology"));
        clickCounts.put("CyberThreat", completeCourseService.getClickCount("CyberThreat"));
        clickCounts.put("Sustainability", completeCourseService.getClickCount("Sustainability"));


//        completeCourseService.incrementClickCount("AI"); //increments click count for AI course
//        completeCourseService.incrementClickCount("DataScience"); //increments click count for DataScience course
//        completeCourseService.incrementClickCount("CloudTechnology"); //increments click count for CloudTechnology course
//        completeCourseService.incrementClickCount("CyberThreat"); //increments click count for CyberThreat course
//        completeCourseService.incrementClickCount("Sustainability"); //increments click count for Sustainability course

        System.out.println("AI Click count: " + clickCounts.get("AI"));
        System.out.println("DataScience Click count: " + clickCounts.get("DataScience"));
        System.out.println("CloudTechnology Click count: " + clickCounts.get("CloudTechnology"));
        System.out.println("CyberThreat Click count: " + clickCounts.get("CyberThreat"));
        System.out.println("Sustainability Click count: " + clickCounts.get("Sustainability"));

        model.addAttribute("clickCounts", clickCounts);
        
        float AITime = Float.parseFloat(cRepo.findByCourseName("AI").getTotalTime());
        float DSTime = Float.parseFloat(cRepo.findByCourseName("DataScience").getTotalTime());
        float CTeTime = Float.parseFloat(cRepo.findByCourseName("CloudTechnology").getTotalTime());
        float CThTime = Float.parseFloat(cRepo.findByCourseName("CyberThreat").getTotalTime());
        float STime = Float.parseFloat(cRepo.findByCourseName("Sustainability").getTotalTime());
        model.addAttribute("AITime", (AITime / 300 * 100));
        model.addAttribute("DSTime", (DSTime / 300 * 100));
        model.addAttribute("CTeTime", (CTeTime / 300 * 100));
        model.addAttribute("CThTime", (CThTime / 300 * 100));
        model.addAttribute("STime", (STime / 300 * 100));

        Integer completedCourses = (Integer) session.getAttribute("completedCourses");
        if (completedCourses == null) {
            completedCourses = 0;
        }
        completedCourses++;
        session.setAttribute("completedCourses", completedCourses);
        int coinsEarned = completedCourses * 50;
        session.setAttribute("coinsEarned", coinsEarned); // Set coinsEarned in session
        model.addAttribute("coinsEarned", coinsEarned);

        return "courses/list";
    }

    @GetMapping("/aiCourse")
    public String aiCourse(HttpServletRequest request){
        LocalDateTime time1 = LocalDateTime.now(); //gets current time
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); //formats current time for database
        Course course = cRepo.findByCourseName("AI"); //finds AI record in table
        course.setStartTime(myTimeFormat.format(time1)); //sets start time as the formatted time
        cRepo.save(course); //saves to table
        String redirectUrl = request.getScheme() + "://skillsbuild.org/college-students/digital-credentials/getting-started-with-enterprise-grade-ai"; //allows to redirect to IBM website

        return"redirect:" + redirectUrl; //returns the redirection
    }
//all methods below work same as method above
    @GetMapping("/dataScience")
    public String dataScience(HttpServletRequest request){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = cRepo.findByCourseName("DataScience");
        course.setStartTime(myTimeFormat.format(time1));
        cRepo.save(course);
        String redirectUrl = request.getScheme() + "://skillsbuild.org/college-students/digital-credentials/getting-started-with-enterprise-data-science";
        return"redirect:" + redirectUrl;

    }

    @GetMapping("/cloudTechnology")
    public String cloudTechnology(HttpServletRequest request){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = cRepo.findByCourseName("CloudTechnology");
        course.setStartTime(myTimeFormat.format(time1));
        cRepo.save(course);
        String redirectUrl = request.getScheme() + "://skillsbuild.org/college-students/digital-credentials/journey-to-cloud-envisioning-your-solution";
        return"redirect:" + redirectUrl;
    }

    @GetMapping("/cyberThreat")
    public String cyberThreat(HttpServletRequest request){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = cRepo.findByCourseName("CyberThreat");
        course.setStartTime(myTimeFormat.format(time1));
        cRepo.save(course);
        String redirectUrl = request.getScheme() + "://skillsbuild.org/college-students/digital-credentials/getting-started-with-threat-intelligence-and-hunting";
        return"redirect:" + redirectUrl;
    }

    @GetMapping("/sustainability")
    public String sustainability(HttpServletRequest request){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = cRepo.findByCourseName("Sustainability");
        course.setStartTime(myTimeFormat.format(time1));
        cRepo.save(course);
        String redirectUrl = request.getScheme() + "://skillsbuild.org/college-students/digital-credentials/fundamentals-of-sustainability-and-technology";
        return"redirect:" + redirectUrl;
    }

    @GetMapping("/pauseAI")
    public String pauseAI(){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = cRepo.findByCourseName("AI");
        String time2 = course.getStartTime();
        LocalDateTime startTime = LocalDateTime.parse(time2, myTimeFormat);
        Duration duration = Duration.between(startTime, time1);
        if (course.getTotalTime() != null){
            float totaltime = Float.parseFloat(course.getTotalTime()) + duration.toSeconds();
            course.setTotalTime(String.valueOf(totaltime));
        }
        else{
            course.setTotalTime(String.valueOf(duration.toSeconds()));
        }
        course.setPausedTime(myTimeFormat.format(time1));

        cRepo.save(course);
        return"redirect:";
    }
    @GetMapping("/pauseDataScience")
    public String pauseDataScience(){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = cRepo.findByCourseName("DataScience");
        String time2 = course.getStartTime();
        LocalDateTime startTime = LocalDateTime.parse(time2, myTimeFormat);
        Duration duration = Duration.between(startTime, time1);
        if (course.getTotalTime() != null){
            float totaltime = Float.parseFloat(course.getTotalTime()) + duration.toSeconds();
            course.setTotalTime(String.valueOf(totaltime));
        }
        else{
            course.setTotalTime(String.valueOf(duration.toSeconds()));
        }
        course.setPausedTime(myTimeFormat.format(time1));
        cRepo.save(course);
        return"redirect:";
    }

    @GetMapping("/pauseCloudTech")
    public String pauseCloudTech(){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = cRepo.findByCourseName("CloudTechnology");
        String time2 = course.getStartTime();
        LocalDateTime startTime = LocalDateTime.parse(time2, myTimeFormat);
        Duration duration = Duration.between(startTime, time1);
        if (course.getTotalTime() != null){
            float totaltime = Float.parseFloat(course.getTotalTime()) + duration.toSeconds();
            course.setTotalTime(String.valueOf(totaltime));
        }
        else{
            course.setTotalTime(String.valueOf(duration.toSeconds()));
        }
        course.setPausedTime(myTimeFormat.format(time1));
        cRepo.save(course);
        return"redirect:";
    }

    @GetMapping("/pauseCyberThreat")
    public String pauseCyberThreat(){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = cRepo.findByCourseName("CyberThreat");
        String time2 = course.getStartTime();
        LocalDateTime startTime = LocalDateTime.parse(time2, myTimeFormat);
        Duration duration = Duration.between(startTime, time1);
        if (course.getTotalTime() != null){
            float totaltime = Float.parseFloat(course.getTotalTime()) + duration.toSeconds();
            course.setTotalTime(String.valueOf(totaltime));
        }
        else{
            course.setTotalTime(String.valueOf(duration.toSeconds()));
        }
        course.setPausedTime(myTimeFormat.format(time1));
        cRepo.save(course);
        return"redirect:";
    }

    @GetMapping("/pauseSustainability")
    public String pauseSustainability(){
        LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Course course = cRepo.findByCourseName("Sustainability");
        String time2 = course.getStartTime();
        LocalDateTime startTime = LocalDateTime.parse(time2, myTimeFormat);
        Duration duration = Duration.between(startTime, time1);
        if (course.getTotalTime() != null){
            float totaltime = Float.parseFloat(course.getTotalTime()) + duration.toSeconds();
            course.setTotalTime(String.valueOf(totaltime));
        }
        else{
            course.setTotalTime(String.valueOf(duration.toSeconds()));
        }
        course.setPausedTime(myTimeFormat.format(time1));
        cRepo.save(course);
        return"redirect:";
    }

    @GetMapping("/topCourses")
    public String getTopCourses(Model model) {
        List<CompleteCourse> topCourses = completeCourseRepository.findTop3ByOrderByClickCountDesc();
        model.addAttribute("topCourses", topCourses);
        return "courses/topCourses";
    }


}

