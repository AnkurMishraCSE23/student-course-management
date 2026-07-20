package com.ankur.studentcoursemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankur.studentcoursemanagement.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>
{
	boolean existsByNameIgnoreCase(String name);
	List<Course> findByNameContainingIgnoreCase(String name);
}
