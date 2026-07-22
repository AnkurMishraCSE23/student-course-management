package com.ankur.studentcoursemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ankur.studentcoursemanagement.dto.EnrollmentRequestDTO;
import com.ankur.studentcoursemanagement.entity.Enrollment;

public interface EnrollmentService
{
	Enrollment enrollStudent(EnrollmentRequestDTO requestDTO);
	Page<Enrollment> getAllEnrollments(Pageable pageable);
	Enrollment getEnrollmentById(Integer id);
	List<Enrollment> getEnrollmentsByStudentId(Integer studentId);
	List<Enrollment> getEnrollmentsByCourseId(Integer courseId);
//	boolean existsByStudentAndCourse(Student student, Course course);
	void deleteEnrollment(Integer id);
//	Enrollment updateEnrollment(Integer id);
}
