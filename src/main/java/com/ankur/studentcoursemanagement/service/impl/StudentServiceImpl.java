package com.ankur.studentcoursemanagement.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ankur.studentcoursemanagement.entity.Student;
import com.ankur.studentcoursemanagement.exception.DuplicateEmailException;
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
//		return studentRepository.save(student);
		
		if(studentRepository.existsByEmail(student.getEmail()))
		{
			throw new DuplicateEmailException("Student with email: " + student.getEmail() + " already exists!");
		}
		
		return studentRepository.save(student);
	}
	
	@Override
	public Page<Student> getAllStudents(Pageable pageable)
	{
		return studentRepository.findAll(pageable);
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
		
		if(!updatedStudent.getEmail().equals(existingStudent.getEmail())
		   && studentRepository.existsByEmail(updatedStudent.getEmail()))
		{
			throw new DuplicateEmailException("Student with email: " + updatedStudent.getEmail() + " already exists!");
		}
		
		existingStudent.setName(updatedStudent.getName());
		existingStudent.setEmail(updatedStudent.getEmail());
		
		return studentRepository.save(existingStudent);
	}
	
	@Override
	public void deleteStudent(Integer id)
	{
		//studentRepository.deleteById(id);
		
		Student studentToDelete = getStudentById(id);
		
		studentRepository.delete(studentToDelete);
	}
	
	@Override
	public Student getStudentByEmail(String email)
	{
//		Student student = studentRepository.findByEmail(email);
//		
//		if(student == null)
//		{
//			throw new StudentNotFoundException("Student with email: " + email + "not found!");
//		}
		
		return studentRepository.findByEmail(email).orElseThrow(() -> new StudentNotFoundException("Student with email: " + email + " not found!"));
	}
	
	@Override
	public List<Student> searchStudentsByName(String name)
	{
		return studentRepository.findByNameContainingIgnoreCase(name);
	}
}
