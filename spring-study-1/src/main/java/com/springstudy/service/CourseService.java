package com.springstudy.service;

import com.springstudy.domain.Course;
import com.springstudy.repo.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CourseService  implements ICourseService {

    @Autowired
    private ICourseRepo courseRepo;
    @Autowired
    private IStudentCourseService studentCourseService;

    @Override
    public Course createCourse(Course course) {
        try {
           return courseRepo.save(course);
        }catch (Exception ex){
            throw  new RuntimeException(ex);
        }
    }

    @Override
    public Iterable<Course> findAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public void removeCourse(Integer id) {
    try {
        studentCourseService.removeByCourseId(id);
        courseRepo.deleteById(id);
    }catch (Exception ex){
        throw new RuntimeException(ex);
    }
    }

    @Override
    public Optional<Course> findById(int id) {
        return courseRepo.findById(id);
    }
}
