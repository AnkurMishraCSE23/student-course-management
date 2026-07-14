package com.ankur.studentcoursemanagement.service.impl;

import org.springframework.stereotype.Service;

import com.ankur.studentcoursemanagement.entity.Student;
import com.ankur.studentcoursemanagement.repository.StudentRepository;
import com.ankur.studentcoursemanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{
	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository)
	{
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
}
