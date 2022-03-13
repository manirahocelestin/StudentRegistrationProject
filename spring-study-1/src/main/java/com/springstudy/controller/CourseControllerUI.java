package com.springstudy.controller;

import com.springstudy.domain.Course;
import com.springstudy.domain.Student;
import com.springstudy.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CourseControllerUI {
    @Autowired
    private ICourseService courseService;

    @GetMapping("/viewCourse")
    public String courseList(Model model){
        model.addAttribute("list",courseService.findAllCourse());
        model.addAttribute("course",new Course());
        return "courses";

    }
    @PostMapping("/registrationCourse")
    public String courseRegistration(@Valid Course course, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("list",courseService.findAllCourse());
            return "courses";

        }
        courseService.createCourse(course);
        return "redirect:/viewCourse";

    }
    @GetMapping("/courseDelete")
    public String deleteCourse(int id){
        courseService.removeCourse(id);
        return "redirect:/viewCourse";

    }

}
