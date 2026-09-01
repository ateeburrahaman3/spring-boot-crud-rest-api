package com.ateeburrahaman.spring_boot_crud_rest_api.service;

import com.ateeburrahaman.spring_boot_crud_rest_api.dto.StudentResponseDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.dto.requestDto.CreateRequestDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.dto.requestDto.UpdateRequestDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.entity.Student;
import com.ateeburrahaman.spring_boot_crud_rest_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

    public boolean deleteStudent(int id)
    {
        Optional<Student> studentExists =  studentRepository.findById(id);
        if (studentExists.isEmpty()) {return false;}
        studentRepository.deleteById(id);
        return true;
    }

    public boolean softDeleteStudent(int id)
    {
        Optional<Student> studentExists = studentRepository.getByIdAndDeletedFalse(id);
        if (studentExists.isEmpty()) {return false;}
        Student studentToDelete = studentExists.get();
        studentToDelete.setDeleted(true);
        studentRepository.save(studentToDelete);
        return true;
    }


    public StudentResponseDto getById(int id)
    {
        Optional<Student> student = studentRepository.getByIdAndDeletedFalse(id);
        return student.map(this::studentToStudentResp).orElse(null);
    }



    public List<StudentResponseDto> getAll()
    {
        List<Student> studentList = studentRepository.findAllByDeletedFalse();
        if (studentList.isEmpty()) {return null;}
        return studentList.stream().map(this::studentToStudentResp)
                .collect(Collectors.toList());
    }

    public StudentResponseDto updateStudent(int id, UpdateRequestDto studentReq)
    {
        Optional<Student> studentExists = studentRepository.getByIdAndDeletedFalse(id);
        if (studentExists.isEmpty())
        {return null;}

        Student updateStudent = studentExists.get();
        updateStudent.setName(studentReq.getName());
        updateStudent.setRollNo(studentReq.getRollNo());
        updateStudent.setBranch(studentReq.getBranch());
        updateStudent.setGender(studentReq.getGender());
        return studentToStudentResp(studentRepository.save(updateStudent));
    }



    //DTO CONVERSIONS>>>>>>>>>>>>>>>>>>
    private Student studentReqToStudent(CreateRequestDto studentReq)
    {
        Student student = new Student();
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setBranch(studentReq.getBranch());
        student.setGender(studentReq.getGender());
        Integer rollNo = studentReq.getRollNo();
        while(studentRepository.existsByRollNo(rollNo)){
            rollNo++;
        }
        student.setRollNo(rollNo);
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

