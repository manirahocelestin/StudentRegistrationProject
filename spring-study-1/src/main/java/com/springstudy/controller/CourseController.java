package com.springstudy.controller;

import com.springstudy.domain.Course;
import com.springstudy.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping(value = "/createCourse",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.OK);
    }
    @GetMapping(value = "findAll",produces = "application/json")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(courseService.findAllCourse(),HttpStatus.OK);
    }
}
