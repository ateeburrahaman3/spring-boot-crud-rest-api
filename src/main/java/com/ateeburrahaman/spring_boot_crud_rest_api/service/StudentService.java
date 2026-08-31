package com.ateeburrahaman.spring_boot_crud_rest_api.service;

import com.ateeburrahaman.spring_boot_crud_rest_api.entity.Student;
import com.ateeburrahaman.spring_boot_crud_rest_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{

    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student student)
    {
        int rollNo = student.getRollNo();
        while(studentRepository.existsByRollNo(rollNo)){
            rollNo++;
        }
        student.setRollNo(rollNo);
        student.setDeleted(false);
        return studentRepository.save(student);
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


    public Student getById(int id)
    {
        Optional<Student> student = studentRepository.getByIdAndDeletedFalse(id);
        return student.orElse(null);
    }



    public List<Student> getAll()
    {
        List<Student> studentList = studentRepository.findAllByDeletedFalse();
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getRollNo))
                .toList();
    }

    public Student updateStudent(int id,Student student)
    {
        Optional<Student> studentExists = studentRepository.getByIdAndDeletedFalse(id);
        if (studentExists.isEmpty())
        {return null;}

        Student updateStudent = studentExists.get();
        updateStudent.setName(student.getName());
        updateStudent.setRollNo(student.getRollNo());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setBranch(student.getBranch());
        updateStudent.setGender(student.getGender());
        return studentRepository.save(updateStudent);
    }
}

