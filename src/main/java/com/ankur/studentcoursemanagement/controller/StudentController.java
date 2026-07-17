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

import com.ankur.studentcoursemanagement.dto.StudentRequestDTO;
import com.ankur.studentcoursemanagement.dto.StudentResponseDTO;
import com.ankur.studentcoursemanagement.mapper.StudentMapper;
import com.ankur.studentcoursemanagement.service.StudentService;

import jakarta.validation.Valid;

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
	public ResponseEntity<StudentResponseDTO> saveStudent(@Valid @RequestBody StudentRequestDTO requestDTO)
	{
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(StudentMapper.toResponseDTO(studentService.saveStudent(StudentMapper.toEntity(requestDTO))));
	}
	
	@GetMapping
	public ResponseEntity<List<StudentResponseDTO>> getAllStudents()
	{
		return ResponseEntity.ok(StudentMapper.toResponseDTOList(studentService.getAllStudents()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Integer id)
	{
		return ResponseEntity.ok(StudentMapper.toResponseDTO(studentService.getStudentById(id)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentRequestDTO updatedStudentRequestDTO)
	{
		return ResponseEntity.ok(StudentMapper.toResponseDTO(studentService.updateStudent(id, StudentMapper.toEntity(updatedStudentRequestDTO))));
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
