package com.springstudy.service;

import com.springstudy.domain.Student;

import java.util.Optional;

public interface IStudentServie {

    Student createStudent(Student student);

    Iterable<Student> findAllStudent();

    void removeStudent(Integer registrationNumber);
    Optional<Student> findById(final int id);
}
