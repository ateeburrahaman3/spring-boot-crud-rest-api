package com.ateeburrahaman.spring_boot_crud_rest_api.repository;

import com.ateeburrahaman.spring_boot_crud_rest_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByDeletedFalse();

    Optional<Student> getByIdAndDeletedFalse(Integer id);

    boolean existsByRollNo(int rollNo);
}
