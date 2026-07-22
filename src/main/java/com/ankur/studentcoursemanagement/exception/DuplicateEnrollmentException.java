package com.ankur.studentcoursemanagement.exception;

public class DuplicateEnrollmentException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public DuplicateEnrollmentException(String msg)
	{
		super(msg);
	}
}
