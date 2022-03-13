package com.springstudy.domain;

import javax.persistence.*;

@Entity
@Table(name="FACULTY")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="name")
    private String name;
}
