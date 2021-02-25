package com.hcl.taskmanager;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.entity.User;
import com.hcl.taskmanager.service.TaskService;
import com.hcl.taskmanager.service.UserService;


/**
 * 
 * @author Phong Van Nguyen
 *
 */
@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;

	/**
	 * initializes database with some users and data
	 */
	@Override
	public void run(String... args) throws Exception {
		User holly = new User();
		holly.setUsername("holly");
		holly.setPassword("holly");
		
		User teo = new User();
		teo.setUsername("teo");
		teo.setPassword("teo");
		
		userService.saveUser(holly);
		userService.saveUser(teo);
		
		User foundHolly = userService.getSingleUser("holly").get();
		User foundTeo = userService.getSingleUser("teo").get();
		
		Task task = new Task();
		task.setTaskName("Task 1");
		task.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15"));
		task.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-22"));
		task.setDescription("Task 1 Description");
		task.setEmail("pnguyen1710@gmail.com");
		task.setSeverity("High");
		task.setOwner(foundHolly);
		
		Task task2 = new Task();
		task2.setTaskName("Task 2");
		task2.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-01"));
		task2.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-07"));
		task2.setDescription("Task 2 Description");
		task2.setEmail("pnguyen1710@gmail.com");
		task2.setSeverity("Low");
		task2.setOwner(foundTeo);
		
		taskService.addTask(task);
		taskService.addTask(task2);
		
	}

}
