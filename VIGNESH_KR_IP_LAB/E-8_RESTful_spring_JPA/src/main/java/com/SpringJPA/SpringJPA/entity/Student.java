package com.SpringJPA.SpringJPA.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String course;

    private int admissionYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public Student() {}

    public Student(Long id, String name, String course, int admissionYear) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.admissionYear = admissionYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", admissionYear=" + admissionYear +
                '}';
    }
}