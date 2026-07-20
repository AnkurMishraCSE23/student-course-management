package com.ankur.studentcoursemanagement.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ankur.studentcoursemanagement.dto.CourseRequestDTO;
import com.ankur.studentcoursemanagement.dto.CourseResponseDTO;
import com.ankur.studentcoursemanagement.entity.Course;

public final class CourseMapper
{
	private CourseMapper() {}
	
	public static Course toEntity(CourseRequestDTO dto)
	{
		Course course = new Course();
		
		course.setName(dto.getName());
		course.setDuration(dto.getDuration());
		course.setFees(dto.getFees());
		
		return course;
	}
	
	public static CourseResponseDTO toResponseDTO(Course entity)
	{
		CourseResponseDTO dto = new CourseResponseDTO();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDuration(entity.getDuration());
		dto.setFees(entity.getFees());
		
		return dto;
	}
	
	public static List<CourseResponseDTO> toResponseDTOList(List<Course> courses)
	{
		List<CourseResponseDTO> responseDTOList = new ArrayList<>();
		
		for(var course : courses)
		{
			responseDTOList.add(toResponseDTO(course));
		}
		
		return responseDTOList;
	}
}
