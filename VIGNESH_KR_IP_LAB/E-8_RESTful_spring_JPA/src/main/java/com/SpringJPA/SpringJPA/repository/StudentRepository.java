package com.SpringJPA.SpringJPA.repository;

import com.SpringJPA.SpringJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}