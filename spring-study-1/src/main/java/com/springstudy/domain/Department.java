package com.springstudy.domain;

import javax.persistence.*;

@Entity
@Table(name="DEPTARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;
}
