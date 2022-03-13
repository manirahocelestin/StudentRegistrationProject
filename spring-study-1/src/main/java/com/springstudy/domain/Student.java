package com.springstudy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity

@Table(name="STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int registrationNumber;
    @NotNull(message = "Names can't be null")
    @Column(name="NAMES")
    private String names;

    @NotNull(message = "dob cant be null")
    @Column(name="DOB")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dob;


    @NotNull(message = "Gender can't be null")
    @Column(name="GENDER")
    @Enumerated(EnumType.STRING)
    private EGender gender;

    @NotNull(message = "Address  can't be null")
    @Column(name="ADDRESS")
    private String address;
/*    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<StudentCourse> studentCourses;
    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",joinColumns = {@JoinColumn(name = "student_id")},inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courseList;*/


    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
