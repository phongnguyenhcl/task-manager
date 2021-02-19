package com.hcl.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.repository.TaskRepository;

@Service
@Transactional
public class TaskService {

	@Autowired
	TaskRepository taskRepo;

	public void addTask(Task newTask) {
		taskRepo.save(newTask);
	}

	public Task getSingleTask(long id) {
		return taskRepo.findById(id).get();
	}
	
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

	public void updateTask(Task updatedTask) {
		taskRepo.save(updatedTask);
	}

	public void deleteTask(long id) {
		taskRepo.deleteById(id);
	}

}
