package com.ankur.studentcoursemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ankur.studentcoursemanagement.entity.Course;

public interface CourseService
{
	Course saveCourse(Course course);
	Page<Course> getAllCourses(Pageable pageable);
	Course getCourseById(Integer id);
	Course updateCourse(Integer id, Course updatedCourse);
	void deleteCourse(Integer id);
	List<Course> searchCoursesByName(String name);
}
