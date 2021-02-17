package com.hcl.taskmanager.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/")
	public String viewHome(Model model) {
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		
		return "index";
	}
	
	@RequestMapping("/create-new-task")
	public String createNewTask(Model model) {
		Task newTask = new Task();
		model.addAttribute("newTask", newTask);
		
		return "create-new-task";
	}
	
	@PostMapping("/save-task")
	public String saveNewTask(@ModelAttribute("newTask") Task newTask) throws ParseException {
		taskService.addTask(newTask);
		
		return "redirect:/";
	}
	
//	@PutMapping("/edit-task/{id}")
	
	
	
}
