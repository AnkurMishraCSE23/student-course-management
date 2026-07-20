package com.ankur.studentcoursemanagement.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ankur.studentcoursemanagement.entity.Course;
import com.ankur.studentcoursemanagement.exception.CourseNotFoundException;
import com.ankur.studentcoursemanagement.exception.DuplicateCourseNameException;
import com.ankur.studentcoursemanagement.repository.CourseRepository;
import com.ankur.studentcoursemanagement.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService
{
	private final CourseRepository courseRepository;
	
	public CourseServiceImpl(CourseRepository courseRepository)
	{
		this.courseRepository = courseRepository;
	}
	
	@Override
	public Course saveCourse(Course course)
	{
		if(courseRepository.existsByNameIgnoreCase(course.getName()))
		{
			throw new DuplicateCourseNameException("Course with name: " + course.getName() + " already exists!");
		}
		
		return courseRepository.save(course);
	}
	
	@Override
	public Page<Course> getAllCourses(Pageable pageable)
	{
		return courseRepository.findAll(pageable);
	}
	
	@Override
	public Course getCourseById(Integer id)
	{
		return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course with ID: " + id + " not found!"));
	}
	
	@Override
	public Course updateCourse(Integer id, Course updatedCourse)
	{
		Course existingCourse = getCourseById(id);
		
		if(!existingCourse.getName().equals(updatedCourse.getName())
		   && courseRepository.existsByNameIgnoreCase(updatedCourse.getName()))
		{
			throw new DuplicateCourseNameException("Course with name: " + updatedCourse.getName() + " already exists!");
		}
		
		existingCourse.setName(updatedCourse.getName());
		existingCourse.setDuration(updatedCourse.getDuration());
		existingCourse.setFees(updatedCourse.getFees());
		
		return courseRepository.save(existingCourse);
	}
	
	@Override
	public void deleteCourse(Integer id)
	{
		Course courseToDelete = getCourseById(id);
		
		courseRepository.delete(courseToDelete);
	}
	
	@Override
	public List<Course> searchCoursesByName(String name)
	{
		return courseRepository.findByNameContainingIgnoreCase(name);
	}
}
