package com.example.repo;

import com.example.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
    public Course findByCourseName(String name);  //allows to search for record using the course name
}
