package com.springstudy.controller;

import com.springstudy.domain.StudentCourse;
import com.springstudy.service.IStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class StudentCourseController {

    @Autowired
    private IStudentCourseService studentCourseService;

    @PostMapping(value = "/createStudentCourse",produces = "application/json",consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody StudentCourse studentCourse){
        return new ResponseEntity<>(studentCourseService.createStudentCourse(studentCourse), HttpStatus.OK);
    }

    @GetMapping(value = "/findAllStudentCourse",produces = "application/json")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(studentCourseService.findAll(),HttpStatus.OK);
    }

}
