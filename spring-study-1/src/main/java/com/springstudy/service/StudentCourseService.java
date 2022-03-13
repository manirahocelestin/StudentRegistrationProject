package com.springstudy.service;

import com.springstudy.domain.StudentCourse;
import com.springstudy.repo.IStudentCourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentCourseService  implements IStudentCourseService {

    @Autowired
    private IStudentCourseRepo studentCourseRepo;

    @Override
    public StudentCourse createStudentCourse(StudentCourse studentCourse) {
        try {
            return studentCourseRepo.save(studentCourse);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Iterable<StudentCourse> findAll() {
        return studentCourseRepo.findAll();
    }

    @Override
    public void removeStudentCourse(Integer id) {
    try {
        studentCourseRepo.deleteById(id);
    }catch(Exception ex){
        throw new RuntimeException(ex);
    }
    }

    @Override
    public void removeByCourseId(Integer code) {
        try {
            studentCourseRepo.removeByCourseCode(code);
        }catch(Exception exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void removeByStudentRegistrationNumber(Integer registrationNumber) {
        try {
            studentCourseRepo.removeByStudentRegistrationNumber(registrationNumber);

        }catch (Exception ex){
            throw  new RuntimeException(ex);
        }
    }

    @Override
    public List<StudentCourse> findByStudentRegistrationNumber(int studentRegistrationNumber) {
        return studentCourseRepo.findByStudentRegistrationNumber(studentRegistrationNumber);
    }
}
