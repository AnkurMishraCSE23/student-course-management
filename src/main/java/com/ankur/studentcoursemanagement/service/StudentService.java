package com.ankur.studentcoursemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ankur.studentcoursemanagement.entity.Student;

public interface StudentService
{
	Student saveStudent(Student student);
//	List<Student> getAllStudents();
	Page<Student> getAllStudents(Pageable pageable);//pageable is like a request where the page, no.per page, sort status are mentioned
	Student getStudentById(Integer id);
	Student updateStudent(Integer id, Student updatedStudent);
	void deleteStudent(Integer id);
	Student getStudentByEmail(String email);
	List<Student> searchStudentsByName(String name);
}
