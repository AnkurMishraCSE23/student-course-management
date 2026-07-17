package com.ankur.studentcoursemanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(studentService.saveStudent(student));
	}
	
	@GetMapping
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id)
	{
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent)
	{
		return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id)
	{
		studentService.deleteStudent(id);
		//return ResponseEntity.ok("Student with id " + id + " deleted successfully.");
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
	}
}
