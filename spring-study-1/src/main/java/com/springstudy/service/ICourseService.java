package com.springstudy.service;

import com.springstudy.domain.Course;

import java.util.Optional;

public interface ICourseService {
    Course createCourse(Course course);
    Iterable<Course> findAllCourse();
    void removeCourse(Integer courseId);
    Optional<Course> findById(int id);

}
