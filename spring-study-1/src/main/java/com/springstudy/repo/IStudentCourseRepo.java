package com.springstudy.repo;

import com.springstudy.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentCourseRepo extends JpaRepository<StudentCourse,Integer> {
    void removeByCourseCode(Integer code);
    void removeByStudentRegistrationNumber(Integer registrationNumber);
    List<StudentCourse> findByStudentRegistrationNumber(int registrationNumber);
}
