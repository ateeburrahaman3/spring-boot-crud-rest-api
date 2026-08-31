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

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        boolean deletedStudent = studentService.deleteStudent(id);
        if (!deletedStudent) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");

    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> deleteSoft(@RequestParam Integer id) {
        boolean deletedStudent = studentService.softDeleteStudent(id);
        if (!deletedStudent) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Soft deleted Student successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getById(@RequestParam Integer id)
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

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestParam Integer id,@RequestBody Student student) {

        Student updatedStudent = studentService.updateStudent(id,student);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedStudent);
    }







}
