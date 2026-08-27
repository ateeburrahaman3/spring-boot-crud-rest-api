package com.ateeburrahaman.spring_boot_crud_rest_api.repository;

import com.ateeburrahaman.spring_boot_crud_rest_api.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {
    public Student createStudent(Student student) {
        System.out.println("Inside Repository");
        System.out.println("created Student");
        System.out.println("Leaving StudentRepository");
        return student;
    }
}
