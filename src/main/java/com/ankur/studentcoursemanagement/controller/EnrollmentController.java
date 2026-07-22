package com.ankur.studentcoursemanagement.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.studentcoursemanagement.dto.EnrollmentRequestDTO;
import com.ankur.studentcoursemanagement.dto.EnrollmentResponseDTO;
import com.ankur.studentcoursemanagement.entity.Enrollment;
import com.ankur.studentcoursemanagement.mapper.EnrollmentMapper;
import com.ankur.studentcoursemanagement.service.EnrollmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController
{
	private final EnrollmentService enrollmentService;
	
	public EnrollmentController(EnrollmentService enrollmentService)
	{
		this.enrollmentService = enrollmentService;
	}
	
	@PostMapping
	public ResponseEntity<EnrollmentResponseDTO> enrollStudent(@Valid @RequestBody EnrollmentRequestDTO requestDTO)
	{
		Enrollment enrollment = enrollmentService.enrollStudent(requestDTO);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(EnrollmentMapper.toResponseDTO(enrollment));
	}
	
	@GetMapping
	public ResponseEntity<Page<EnrollmentResponseDTO>> getAllEnrollments(Pageable pageable)
	{
		Page<Enrollment> enrollments = enrollmentService.getAllEnrollments(pageable);
		
		Page<EnrollmentResponseDTO> response = enrollments.map(EnrollmentMapper :: toResponseDTO);
		
		return ResponseEntity
				.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnrollmentResponseDTO> getEnrollmentById(@PathVariable Integer id)
	{
		Enrollment enrollment = enrollmentService.getEnrollmentById(id);
		
		return ResponseEntity
				.ok(EnrollmentMapper.toResponseDTO(enrollment));
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<List<EnrollmentResponseDTO>> getEnrollmentsByStudentId(@PathVariable Integer id)
	{
		List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(id);
		
		return ResponseEntity
				.ok(EnrollmentMapper.toResponseDTOList(enrollments));
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<List<EnrollmentResponseDTO>> getEnrollmentsByCourseId(@PathVariable Integer id)
	{
		List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourseId(id);
		
		return ResponseEntity
				.ok(EnrollmentMapper.toResponseDTOList(enrollments));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEnrollment(@PathVariable Integer id)
	{
		enrollmentService.deleteEnrollment(id);
		
		return ResponseEntity
				.noContent()
				.build();
	}
}
