package com.SpringJPA.SpringJPA.config;

import com.SpringJPA.SpringJPA.entity.Student;
import com.SpringJPA.SpringJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StudenDataLoader  implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Autowired
    public StudenDataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
       studentRepository.save(new Student(null, "Rimi", "one", 1993));
        List<Student> dummyStudents = Arrays.asList(
                new Student(null, "Rimi", "one", 1993),
                new Student(null, "John", "two", 1995),
                new Student(null, "Alice", "three", 1998),
                new Student(null, "Bob", "one", 1997),
                new Student(null, "Eva", "two", 1994),
                new Student(null, "Sam", "three", 1996),
                new Student(null, "Lily", "one", 1999),
                new Student(null, "David", "two", 1992),
                new Student(null, "Sophie", "three", 1991),
                new Student(null, "Chris", "one", 1990),
                new Student(null, "Emma", "two", 1995),
                new Student(null, "Michael", "three", 1998),
                new Student(null, "Olivia", "one", 1996),
                new Student(null, "Daniel", "two", 1993),
                new Student(null, "Grace", "three", 1994)
        );

        studentRepository.saveAll(dummyStudents);
    }
}