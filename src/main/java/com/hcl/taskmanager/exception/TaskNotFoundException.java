package com.hcl.taskmanager.exception;

public class TaskNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TaskNotFoundException (long id) {
		
		super(String.format("Task with Id %d not found", id));
	}

}
