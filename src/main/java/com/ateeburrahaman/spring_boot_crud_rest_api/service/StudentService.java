package com.ateeburrahaman.spring_boot_crud_rest_api.service;

import com.ateeburrahaman.spring_boot_crud_rest_api.entity.Student;
import com.ateeburrahaman.spring_boot_crud_rest_api.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        System.out.println("Inside StudentService");
        Student student1 = studentRepository.createStudent(student);
        System.out.println("Leaving StudentService");
        return student1;
    }
}
