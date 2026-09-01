package com.ateeburrahaman.spring_boot_crud_rest_api.service;

import com.ateeburrahaman.spring_boot_crud_rest_api.dto.responseDto.StudentResponseDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.dto.requestDto.CreateRequestDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.dto.requestDto.UpdateRequestDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.entity.Student;
import com.ateeburrahaman.spring_boot_crud_rest_api.exception.ResourceNotFoundException;
import com.ateeburrahaman.spring_boot_crud_rest_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService
{

    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public StudentResponseDto createStudent(CreateRequestDto studentReq)
    {
        Student student  = studentReqToStudent(studentReq);
        return studentToStudentResp(studentRepository.save(student));
    }

    public void deleteStudent(int id)
    {
        studentRepository
                .getByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student With ID :"+id+" Not Found..."));

        studentRepository.deleteById(id);
    }

    public void softDeleteStudent(int id)
    {
        Student studentToDelete = studentRepository
                .getByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student With ID :"+id+" Not Found..."));

        studentToDelete.setDeleted(true);
        studentRepository.save(studentToDelete);
    }


    public StudentResponseDto getById(int id)
    {
        Student student = studentRepository
                .getByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student With ID :"+id+" Not Found..."));

        return studentToStudentResp(student);
    }



    public List<StudentResponseDto> getAll()
    {
        List<Student> studentList = studentRepository
                .findAllByDeletedFalse()
                .orElseThrow(() -> new ResourceNotFoundException("Student List is Empty..."));

        return studentList.stream().map(this::studentToStudentResp)
                .collect(Collectors.toList());
    }

    public StudentResponseDto updateStudent(int id, UpdateRequestDto studentReq)
    {
        Student studentToUpdate = studentRepository
                .getByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student With ID :"+id+" Not Found..."));

        studentToUpdate.setName(studentReq.getName());
        studentToUpdate.setRollNo(studentReq.getRollNo());
        studentToUpdate.setBranch(studentReq.getBranch());
        studentToUpdate.setGender(studentReq.getGender());
        return studentToStudentResp(studentRepository.save(studentToUpdate));
    }



    //DTO CONVERSIONS>>>>>>>>>>>>>>>>>>
    private Student studentReqToStudent(CreateRequestDto studentReq)
    {
        Student student = new Student();
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setBranch(studentReq.getBranch());
        student.setGender(studentReq.getGender());
        student.setRollNo(studentReq.getRollNo());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private StudentResponseDto studentToStudentResp(Student student)
    {
        StudentResponseDto studentResp = new StudentResponseDto();
        studentResp.setId(student.getId());
        studentResp.setName(student.getName());
        studentResp.setEmail(student.getEmail());
        studentResp.setBranch(student.getBranch());
        studentResp.setGender(student.getGender());
        studentResp.setRollNo(student.getRollNo());
        return studentResp;
    }
}

