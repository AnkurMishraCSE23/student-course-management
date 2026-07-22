package com.ankur.studentcoursemanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EnrollmentRequestDTO
{
	@NotNull(message = "Student ID is required!")
	@Positive(message = "Student ID must be positive!")
	private Integer studentId;
	
	@NotNull(message = "Course ID is required!")
	@Positive(message = "Course ID must be positive!")
	private Integer courseId;
	
	public EnrollmentRequestDTO() {}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
}
