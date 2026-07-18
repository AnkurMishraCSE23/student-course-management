package com.ankur.studentcoursemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankur.studentcoursemanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
	Optional<Student> findByEmail(String email);
	boolean existsByEmail(String email);
}
