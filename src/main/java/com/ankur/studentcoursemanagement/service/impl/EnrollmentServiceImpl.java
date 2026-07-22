package com.ankur.studentcoursemanagement.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ankur.studentcoursemanagement.dto.EnrollmentRequestDTO;
import com.ankur.studentcoursemanagement.entity.Course;
import com.ankur.studentcoursemanagement.entity.Enrollment;
import com.ankur.studentcoursemanagement.entity.Student;
import com.ankur.studentcoursemanagement.exception.DuplicateEnrollmentException;
import com.ankur.studentcoursemanagement.exception.EnrollmentNotFoundException;
import com.ankur.studentcoursemanagement.repository.EnrollmentRepository;
import com.ankur.studentcoursemanagement.service.CourseService;
import com.ankur.studentcoursemanagement.service.EnrollmentService;
import com.ankur.studentcoursemanagement.service.StudentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService
{
	private final EnrollmentRepository enrollmentRepository;
	private final StudentService studentService;
	private final CourseService courseService;
	
	public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
								 StudentService studentService,
								 CourseService courseService)
	{
		this.enrollmentRepository = enrollmentRepository;
		this.studentService = studentService;
		this.courseService = courseService;
	}
	
	@Override
	public Enrollment enrollStudent(EnrollmentRequestDTO requestDTO)
	{
		Student student = studentService.getStudentById(requestDTO.getStudentId());
		Course course = courseService.getCourseById(requestDTO.getCourseId());
		
		if(enrollmentRepository.existsByStudentAndCourse(student, course))
		{
			throw new DuplicateEnrollmentException("Enrollment already exists!");
		}
		
		Enrollment enrollment = new Enrollment();
		enrollment.setStudent(student);
		enrollment.setCourse(course);
		enrollment.setEnrollmentDate(LocalDate.now());
		enrollment.setStatus("ENROLLED");
		
		return enrollmentRepository.save(enrollment);
	}
	
	@Override
	public Page<Enrollment> getAllEnrollments(Pageable pageable)
	{
		return enrollmentRepository.findAll(pageable);
	}
	
	@Override
	public Enrollment getEnrollmentById(Integer id)
	{
		return enrollmentRepository.findById(id).orElseThrow(() -> new EnrollmentNotFoundException("Enrollment with ID: " + id + " not found!"));
	}
	
	@Override
	public List<Enrollment> getEnrollmentsByStudentId(Integer studentId)
	{
		Student student = studentService.getStudentById(studentId);
		
		return enrollmentRepository.findByStudent(student);
	}
	
	@Override
	public List<Enrollment> getEnrollmentsByCourseId(Integer courseId)
	{
		Course course = courseService.getCourseById(courseId);
		
		return enrollmentRepository.findByCourse(course);
	}
	
	@Override
	public void deleteEnrollment(Integer id)
	{
		Enrollment enrollmentToDelete = getEnrollmentById(id);
		
		enrollmentRepository.delete(enrollmentToDelete);
	}
}
