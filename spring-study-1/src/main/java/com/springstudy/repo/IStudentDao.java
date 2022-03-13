package com.springstudy.repo;

import com.springstudy.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDao  extends JpaRepository< Student,Integer> {


}
