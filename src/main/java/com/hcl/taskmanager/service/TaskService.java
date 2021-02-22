package com.hcl.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.repository.TaskRepository;

@Service
@Transactional
public class TaskService {

	private TaskRepository taskRepo;

	public TaskService(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}

	public void addTask(Task newTask) {
		taskRepo.save(newTask);
	}

	public Optional<Task> getSingleTask(long id) {
		return taskRepo.findById(id);
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
	
	public boolean doesTaskExist(long id) {
		return taskRepo.existsById(id);
	}

}
