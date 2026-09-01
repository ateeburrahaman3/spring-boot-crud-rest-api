package com.ateeburrahaman.spring_boot_crud_rest_api.controller;

import com.ateeburrahaman.spring_boot_crud_rest_api.dto.responseDto.StudentResponseDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.dto.requestDto.CreateRequestDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.dto.requestDto.UpdateRequestDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.service.StudentService;
import jakarta.validation.Valid;
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
    public ResponseEntity<StudentResponseDto> create(@Valid @RequestBody CreateRequestDto studentReq) {
        StudentResponseDto savedStudent = studentService.createStudent(studentReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();

    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> deleteSoft(@RequestParam Integer id) {
        studentService.softDeleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Soft deleted Student successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<StudentResponseDto> getById(@RequestParam Integer id)
    {
        StudentResponseDto studentResp = studentService.getById(id);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponseDto>> getAll()
    {
        List<StudentResponseDto> studentList = studentService.getAll();
        return ResponseEntity.ok(studentList);

    }

    @PutMapping("/update")
    public ResponseEntity<StudentResponseDto> update(@RequestParam Integer id,@Valid @RequestBody UpdateRequestDto studentReq) {

        StudentResponseDto studentResp = studentService.updateStudent(id,studentReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResp);
    }



}
