package com.example.service;

import com.example.model.CompleteCourse;
import com.example.repo.CompleteCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@Service
public class CompleteCourseService {
    @Autowired
    private CompleteCourseRepository completeCourseRepository;

    @Autowired
    private EntityManager entityManager;

    // maybe broke the thing and whitelabeled
//    @Transactional
//    public void incrementClickCount(String courseName) {
//        CompleteCourse completeCourse = completeCourseRepository.findByCourseName(courseName);
//        System.out.println("Before increment: " + completeCourse.getClickCount());
//
//        completeCourseRepository.incrementClickCount(courseName);
//        entityManager.flush();
//
//        completeCourse = completeCourseRepository.findByCourseName(courseName);
//        System.out.println("After increment: " + completeCourse.getClickCount());
//    }

    @Transactional
    public void incrementClickCount(String courseName) {
        completeCourseRepository.incrementClickCount(courseName);
        entityManager.flush();
    }

    public int getClickCount(String courseName) {
        CompleteCourse completeCourse = completeCourseRepository.findByCourseName(courseName);
        return completeCourse != null ? completeCourse.getClickCount() : 0;
    }
}
