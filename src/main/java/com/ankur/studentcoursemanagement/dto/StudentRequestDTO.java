package com.ankur.studentcoursemanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO
{
	@NotBlank(message = "Name can not be blank!")
	@Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
	private String name;
	
	@NotBlank(message = "Email can not be blank!")
	@Email(message = "Please enter a valid email!")
	private String email;
	
	public StudentRequestDTO() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
