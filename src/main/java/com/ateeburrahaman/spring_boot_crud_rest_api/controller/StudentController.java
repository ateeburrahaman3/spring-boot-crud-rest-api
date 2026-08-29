package com.ateeburrahaman.spring_boot_crud_rest_api.controller;

import com.ateeburrahaman.spring_boot_crud_rest_api.entity.Student;
import com.ateeburrahaman.spring_boot_crud_rest_api.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student) {

        Student savedStudent = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean deletedStudent = studentService.deleteStudent(id);
        if (!deletedStudent) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id)
    {
        Student student = studentService.getById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll()
    {
        List<Student> studentList = studentService.getAll();
        if (studentList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable int id,@RequestBody Student student) {

        Student updatedStudent = studentService.updateStudent(id,student);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedStudent);
    }







}
