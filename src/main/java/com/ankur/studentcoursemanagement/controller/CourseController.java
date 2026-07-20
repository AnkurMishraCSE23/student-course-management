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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.studentcoursemanagement.dto.CourseRequestDTO;
import com.ankur.studentcoursemanagement.dto.CourseResponseDTO;
import com.ankur.studentcoursemanagement.entity.Course;
import com.ankur.studentcoursemanagement.mapper.CourseMapper;
import com.ankur.studentcoursemanagement.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController
{
	private final CourseService courseService;
	
	public CourseController(CourseService courseService)
	{
		this.courseService = courseService;
	}
	
	@PostMapping
	public ResponseEntity<CourseResponseDTO> saveCourse(@Valid @RequestBody CourseRequestDTO requestDTO)
	{
		Course courseToSave = CourseMapper.toEntity(requestDTO);
		Course savedCourse = courseService.saveCourse(courseToSave);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(CourseMapper.toResponseDTO(savedCourse));
	}
	
	@GetMapping
	public ResponseEntity<Page<CourseResponseDTO>> getAllCourses(Pageable pageable)
	{
		Page<Course> courses = courseService.getAllCourses(pageable);
		
		Page<CourseResponseDTO> response = courses.map(CourseMapper :: toResponseDTO);
		
		return ResponseEntity
				.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable Integer id)
	{
		Course course = courseService.getCourseById(id);
		
		return ResponseEntity
				.ok(CourseMapper.toResponseDTO(course));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Integer id, @Valid @RequestBody CourseRequestDTO updatedCourseRequestDTO)
	{
		Course course = courseService.updateCourse(id, CourseMapper.toEntity(updatedCourseRequestDTO));
		
		return ResponseEntity
				.ok(CourseMapper.toResponseDTO(course));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Integer id)
	{
		courseService.deleteCourse(id);
		
		return ResponseEntity
				.noContent()
				.build();
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<CourseResponseDTO>> searchCoursesByName(@RequestParam String name)
	{
		List<Course> courses = courseService.searchCoursesByName(name);
		
		return ResponseEntity
				.ok(CourseMapper.toResponseDTOList(courses));
	}
}
