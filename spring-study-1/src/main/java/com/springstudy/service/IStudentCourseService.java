package com.springstudy.service;

import com.springstudy.domain.StudentCourse;

import java.util.List;

public interface IStudentCourseService {
    StudentCourse createStudentCourse(StudentCourse studentCourse);

    Iterable<StudentCourse> findAll();

    void removeStudentCourse(Integer id);

    void removeByCourseId(Integer id);
    void removeByStudentRegistrationNumber(Integer registrationNumber);
    List<StudentCourse> findByStudentRegistrationNumber(int studentRegistrationNumber);
}
