package com.example.repo;

import com.example.model.CompleteCourse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompleteCourseRepository extends CrudRepository<CompleteCourse, Integer> {
    CompleteCourse findByCourseName(String name);

    @Transactional
    @Modifying
    @Query("update CompleteCourse c set c.clickCount = c.clickCount + 1 where c.courseName = ?1")
    void incrementClickCount(String courseName);

    @Query("SELECT c FROM CompleteCourse c ORDER BY c.clickCount DESC")
    List<CompleteCourse> findTop3ByOrderByClickCountDesc();
}
