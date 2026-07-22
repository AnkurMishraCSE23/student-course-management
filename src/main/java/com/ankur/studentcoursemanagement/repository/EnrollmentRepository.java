package com.ankur.studentcoursemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankur.studentcoursemanagement.entity.Course;
import com.ankur.studentcoursemanagement.entity.Enrollment;
import com.ankur.studentcoursemanagement.entity.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>
{
	boolean existsByStudentAndCourse(Student student, Course course);
	List<Enrollment> findByStudent(Student student);
	List<Enrollment> findByCourse(Course course);
}
