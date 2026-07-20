package com.ankur.studentcoursemanagement.dto;

public class CourseResponseDTO
{
	private Integer id;
	private String name;
	private Integer duration;
	private Double fees;
	
	public CourseResponseDTO() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
