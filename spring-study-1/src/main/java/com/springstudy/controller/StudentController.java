package com.springstudy.controller;

import com.springstudy.domain.EGender;
import com.springstudy.domain.Student;
import com.springstudy.service.IStudentServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

//@RestController
public class StudentController {

    @Autowired
    private IStudentServie studentService;

    @GetMapping(name="/index")
    public ResponseEntity<?> home(){
        return new ResponseEntity<>("Helo World", HttpStatus.OK);
    }

    @PostMapping(value = "/helloWorld",produces = "application/json")
    public ResponseEntity<?> findAll(@RequestParam("name")String name){
        Student std=new Student();
        std.setNames(name);
        std.setAddress("Address");
        std.setGender(EGender.FEMALE);
        std.setDob(new Date());
        return new ResponseEntity<>(std, HttpStatus.OK);
    }

    @PostMapping(value = "/createStudent",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createStudent(@RequestBody Student student){

        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.OK);
    }

    @GetMapping(value = "/findAllStudent",produces = "application/json")
    public ResponseEntity<?> findAllStudent(){
        return new ResponseEntity<>(studentService.findAllStudent(),HttpStatus.OK);
    }

    @PostMapping(value = "/deleteStudent",produces = "application/json")
    public ResponseEntity<?> deleteStudent(@RequestParam("student_id")String studentId){
        studentService.removeStudent(Integer.parseInt(studentId));
        return new ResponseEntity<>("deleted Sucessfull",HttpStatus.OK);
    }

}
