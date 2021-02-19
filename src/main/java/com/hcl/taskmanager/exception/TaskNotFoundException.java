package com.hcl.taskmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.dao.EmptyResultDataAccessException;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Task not found!") 
public class TaskNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TaskNotFoundException (long id) {
		
		super(String.format("Task with Id %d not found", id));
	}

}
// methods to any controller to specifically handle exceptions thrown by request handling