package com.school.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
  List<Student> findByRegistered(boolean registered);
  List<Student> findByNameContaining(String name);
  List<Student> findById(long id);
}