package com.ankur.studentcoursemanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.studentcoursemanagement.entity.Student;
import com.ankur.studentcoursemanagement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController 
{
	private final StudentService studentService;
	
	public StudentController(StudentService studentService)
	{
		this.studentService = studentService;
	}
	
	@PostMapping
	public Student saveStudent(@RequestBody Student student)
	{
		return studentService.saveStudent(student);
	}
}
