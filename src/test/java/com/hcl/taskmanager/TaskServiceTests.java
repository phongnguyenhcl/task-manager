package com.hcl.taskmanager;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.service.TaskService;

@SpringBootTest
public class TaskServiceTests {

	@Autowired
	TaskService taskService;
	
	@Test
	public void testUpdateTaskMethod() throws ParseException {
		long updatedTaskId = 2;
		
		Task task = new Task();
		task.setId(updatedTaskId);
		task.setTaskName("Task 8888");
		task.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15"));
		task.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-22"));
		task.setDescription("Task 1 Description");
		task.setEmail("Task 10000 Email");
		task.setSeverity("High Severity");
		task.setOwner("Teo");
		
		taskService.updateTask(task);
		
		Task foundTask = taskService.getSingleTask(updatedTaskId);
		
		assertThat(foundTask).isEqualTo(task);
	}
}
