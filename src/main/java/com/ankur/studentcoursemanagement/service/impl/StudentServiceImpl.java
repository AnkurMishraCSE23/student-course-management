package com.ankur.studentcoursemanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ankur.studentcoursemanagement.entity.Student;
import com.ankur.studentcoursemanagement.exception.StudentNotFoundException;
import com.ankur.studentcoursemanagement.repository.StudentRepository;
import com.ankur.studentcoursemanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{
	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository)
	{
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	@Override
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	@Override
	public Student getStudentById(Integer id)
	{
		//return studentRepository.findById(id).orElse(null);
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID: " + id + " not found!"));
	}
	
	@Override
	public Student updateStudent(Integer id, Student updatedStudent)
	{
		Student existingStudent = getStudentById(id);
		
		existingStudent.setName(updatedStudent.getName());
		existingStudent.setEmail(updatedStudent.getEmail());
		
		return saveStudent(existingStudent);
	}
	
	@Override
	public void deleteStudent(Integer id)
	{
		//studentRepository.deleteById(id);
		
		Student studentToDelete = getStudentById(id);
		
		studentRepository.delete(studentToDelete);
	}
}
