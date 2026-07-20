package com.ankur.studentcoursemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class CourseRequestDTO
{
	@NotBlank(message = "Name can not be blank!")
	@Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
	private String name;
	
	@NotNull(message = "Duration is required!")
	@Positive(message = "Duration must be greater than 0!")
	private Integer duration;
	
	@NotNull(message = "Fees is required!")
	@PositiveOrZero(message = "Fees must not be negative!")
	private Double fees;
	
	public CourseRequestDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}
}
