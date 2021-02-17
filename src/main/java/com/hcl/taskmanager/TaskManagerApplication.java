package com.hcl.taskmanager;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.service.TaskService;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}
	
	@Autowired
	TaskService taskService;

	@Override
	public void run(String... args) throws Exception {
		Task task = new Task();
		task.setTaskName("Task 1");
		task.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15"));
		task.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-22"));
		task.setDescription("Task 1 Description");
		task.setEmail("Task 1 Email");
		task.setSeverity("Task 1 High");
		task.setOwner("Teo");
		
		Task task2 = new Task();
		task2.setTaskName("Task 2");
		task2.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-01"));
		task2.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-07"));
		task2.setDescription("Task 2 Description");
		task2.setEmail("Task 2 Email");
		task2.setSeverity("Task 2 Low");
		task2.setOwner("Phong");
		
		taskService.addTask(task);
		taskService.addTask(task2);
	}

}
