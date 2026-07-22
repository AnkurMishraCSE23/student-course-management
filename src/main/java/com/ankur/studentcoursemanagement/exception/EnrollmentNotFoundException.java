package com.ankur.studentcoursemanagement.exception;

public class EnrollmentNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public EnrollmentNotFoundException(String msg)
	{
		super(msg);
	}
}
