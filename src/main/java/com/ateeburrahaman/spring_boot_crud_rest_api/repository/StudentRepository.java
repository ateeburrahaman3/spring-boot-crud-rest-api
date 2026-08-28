package com.ateeburrahaman.spring_boot_crud_rest_api.repository;

import com.ateeburrahaman.spring_boot_crud_rest_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
