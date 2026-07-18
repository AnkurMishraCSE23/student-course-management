package com.ankur.studentcoursemanagement.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ankur.studentcoursemanagement.response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException ex, HttpServletRequest request)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());//NOT_FOUND itself can be an enum;
		errorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setPath(request.getRequestURI());
		
		
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(errorResponse);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request)
	{
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult()
		  .getFieldErrors()
		  .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());//NOT_FOUND itself can be an enum;
		errorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setPath(request.getRequestURI());
		errorResponse.setErrors(errors);
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(errorResponse);
	}
	
	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateEmailException(DuplicateEmailException ex, HttpServletRequest request)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setStatus(HttpStatus.CONFLICT.value());//NOT_FOUND itself can be an enum;
		errorResponse.setError(HttpStatus.CONFLICT.getReasonPhrase());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setPath(request.getRequestURI());
		
		
		
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(errorResponse);
	}
}
