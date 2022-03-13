package com.springstudy.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    @Column(name="NAME")
    @NotNull(message = "name can't be null")
    private String name;
    @Column(name = "NUMBER_OF_HOURS")
    @NotNull(message = "numberOfHours can't be null")
    private int numberOfHOurs;
  /*  @ManyToMany(mappedBy = "courseList")
    private List<Student>students;*/

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfHOurs() {
        return numberOfHOurs;
    }

    public void setNumberOfHOurs(int numberOfHOurs) {
        this.numberOfHOurs = numberOfHOurs;
    }
}
