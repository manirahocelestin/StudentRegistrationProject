package com.springstudy.controller;

import com.springstudy.domain.EGender;
import com.springstudy.domain.Student;
import com.springstudy.service.IStudentServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
public class StudentControllerUI {

    @Autowired
    private IStudentServie studentServie;

    @GetMapping("/viewStudent")
    public String index(Model model){
        model.addAttribute("studentList",studentServie.findAllStudent());
        model.addAttribute("student",new Student());
        model.addAttribute("genders", Arrays.asList(EGender.values()));
        return "student";
    }


    @GetMapping("/updateStudent")
    public String onUpdate(@RequestParam("id") int id,Model model){
        Student student=studentServie.findById(id).get();
        model.addAttribute("studentList",studentServie.findAllStudent());
        model.addAttribute("student",student);
        model.addAttribute("genders", Arrays.asList(EGender.values()));
        return "student";
    }

    @PostMapping("/studentRegistration")
    public  String registerStudent(@Valid Student student, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("studentList",studentServie.findAllStudent());
            model.addAttribute("genders", Arrays.asList(EGender.values()));
            return "student";
        }
        studentServie.createStudent(student);
        return "redirect:/viewStudent";
    }
    @GetMapping("/deletedStudent")
    public String removeStudent(int id){
        studentServie.removeStudent(id);
        return "redirect:/viewStudent";
    }

}
