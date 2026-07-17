package com.ankur.studentcoursemanagement.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ankur.studentcoursemanagement.dto.StudentRequestDTO;
import com.ankur.studentcoursemanagement.dto.StudentResponseDTO;
import com.ankur.studentcoursemanagement.entity.Student;

public final class StudentMapper
{
	private StudentMapper() {}
	
	public static Student toEntity(StudentRequestDTO dto)
	{
		Student student = new Student();
		
		student.setName(dto.getName());
		student.setEmail(dto.getEmail());
		
		return student;
	}
	
	public static StudentResponseDTO toResponseDTO(Student entity)
	{
		StudentResponseDTO dto = new StudentResponseDTO();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		
		return dto;
	}
	
	public static List<StudentResponseDTO> toResponseDTOList(List<Student> entities)
	{
		List<StudentResponseDTO> responseDtoList = new ArrayList<StudentResponseDTO>();
		
		for(var entity : entities)
		{
			responseDtoList.add(toResponseDTO(entity));
		}
		
		return responseDtoList;
	}
}
