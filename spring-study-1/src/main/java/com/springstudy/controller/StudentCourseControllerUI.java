package com.springstudy.controller;

import com.springstudy.domain.Course;
import com.springstudy.domain.Student;
import com.springstudy.domain.StudentCourse;
import com.springstudy.service.ICourseService;
import com.springstudy.service.IStudentCourseService;
import com.springstudy.service.IStudentServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentCourseControllerUI {
    @Autowired
    private IStudentCourseService studentCourseService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IStudentServie studentServie;

    @GetMapping(path = "studentCourse")
    public String viewStudentCourse(@RequestParam("studentId")int studentId, Model model){
        model.addAttribute("courses",courseService.findAllCourse());
        model.addAttribute("studentCourse",studentCourseService.findByStudentRegistrationNumber(studentId));
        model.addAttribute("studentId",studentId);
        return "studentCourse";
    }

    @PostMapping("/studentCourseReg")
    public String assingCourse(@RequestParam("studentId")int studentId,@RequestParam("course")int courseCode){
        Student student=studentServie.findById(studentId).get();
        Course course=courseService.findById(courseCode).get();
        StudentCourse studentCourse=new StudentCourse();
        studentCourse.setCourse(course);
        studentCourse.setStudent(student);
        studentCourseService.createStudentCourse(studentCourse);
        return "redirect:/studentCourse?studentId="+studentId;
    }

}
