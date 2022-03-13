package com.springstudy.service;

import com.springstudy.domain.Student;
import com.springstudy.repo.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StudentService  implements  IStudentServie{

    @Autowired
    private IStudentDao studentDao;

    @Override
    public Student createStudent(Student student) {
      try {
          return studentDao.save(student);
      }catch(Exception x){
          throw new RuntimeException(x);
      }
    }

    @Override
    public Iterable<Student> findAllStudent() {
        return studentDao.findAll();
    }

    @Override
    public void removeStudent(Integer  registrationNumber) {
    try {
        studentDao.deleteById(registrationNumber);
    }catch (Exception e){
        throw new RuntimeException(e);
    }
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentDao.findById(id);
    }
}
