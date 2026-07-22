package com.ankur.studentcoursemanagement.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ankur.studentcoursemanagement.dto.EnrollmentResponseDTO;
import com.ankur.studentcoursemanagement.entity.Enrollment;

public final class EnrollmentMapper
{
	private EnrollmentMapper() {}
	
	public static EnrollmentResponseDTO toResponseDTO(Enrollment enrollment)
	{
		EnrollmentResponseDTO responseDTO = new EnrollmentResponseDTO();
		
		responseDTO.setId(enrollment.getId());
		responseDTO.setStudentId(enrollment.getStudent().getId());
		responseDTO.setStudentName(enrollment.getStudent().getName());
		responseDTO.setCourseId(enrollment.getCourse().getId());
		responseDTO.setCourseName(enrollment.getCourse().getName());
		responseDTO.setEnrollmentDate(enrollment.getEnrollmentDate());
		responseDTO.setStatus(enrollment.getStatus());
		
		return responseDTO;
	}
	
	public static List<EnrollmentResponseDTO> toResponseDTOList(List<Enrollment> enrollments)
	{
		List<EnrollmentResponseDTO> responseDTOList = new ArrayList<>();
		
		for(var enrollment : enrollments)
		{
			responseDTOList.add(toResponseDTO(enrollment));
		}
		
		return responseDTOList;
	}
}
