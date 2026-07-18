package com.ankur.studentcoursemanagement.service;

import java.util.List;

import com.ankur.studentcoursemanagement.entity.Student;

public interface StudentService
{
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(Integer id);
	Student updateStudent(Integer id, Student updatedStudent);
	void deleteStudent(Integer id);
	Student getStudentByEmail(String email);
}
