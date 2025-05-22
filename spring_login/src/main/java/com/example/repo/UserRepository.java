package com.example.repo;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByName(String name);

    /* method to find 5 Users with highest number of completed courses
    the number of Users for this method could be changed
    or there could be multiple methods to find different number of Users */
    public List<User> findFirst5ByOrderByCompletedCourseCountDesc();

    // similar method to find 5 Users with highest number of achievements
    public List<User> findFirst5ByOrderByAchievementCountDesc();


}
