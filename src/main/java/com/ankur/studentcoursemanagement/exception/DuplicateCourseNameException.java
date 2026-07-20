package com.ankur.studentcoursemanagement.exception;

public class DuplicateCourseNameException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public DuplicateCourseNameException(String msg)
	{
		super(msg);
	}
}
