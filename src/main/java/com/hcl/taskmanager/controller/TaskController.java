package com.hcl.taskmanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.exception.TaskNotFoundException;
import com.hcl.taskmanager.service.TaskService;
import com.hcl.taskmanager.service.UserService;

@Controller
public class TaskController {
	
	private TaskService taskService;
	private UserService userService;

	public TaskController(TaskService taskService, UserService userService) {
		this.taskService = taskService;
		this.userService = userService;
	}
	
	/**
	 * global attribute 
	 * @param model
	 */
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("users", userService.getAllUsers());
	}
	
	/**
	 * view homepage
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		return "index";
	}
	
	/**
	 * list all tasks and owners in the database
	 * @param model
	 * @return
	 */
	@GetMapping("/tasks")
	public String viewTasks(Model model) {
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		
		return "tasks";
	}
	
	/**
	 * creates a new task and assign it to an owner
	 * @param model
	 * @return
	 */
	@RequestMapping("/tasks/create-new-task")
	public String createNewTaskForm(Model model) {
		model.addAttribute("newTask", new Task());
		
		return "create-new-task";
	}
	
	/**
	 * save new task to database
	 * @param newTask
	 * @return
	 */
	@PostMapping("/tasks/save-task")
	public String saveNewTask(Task newTask) {
		taskService.addTask(newTask);
		
		return "redirect:/tasks";
	}
	
	/**
	 * edit task form
	 * @param id
	 * @return
	 */
	@RequestMapping("/tasks/edit-task/{id}")
	public ModelAndView editTaskForm(@PathVariable(name = "id") long id) {
		ModelAndView mv = new ModelAndView("edit-task");
		Task task = taskService.getSingleTask(id).orElseThrow(() -> new TaskNotFoundException(id));
		mv.addObject("task", task);
		
		return mv;
	}

	@PostMapping("tasks/update-task")
	public String updateTask(Task updatedTask) {
		taskService.updateTask(updatedTask);
		
		return "redirect:/tasks";
	}
	
	@RequestMapping("tasks/delete-task/{id}")
	public String deleteTask(@PathVariable(name = "id") long id) {
		if (!taskService.doesTaskExist(id)) {
			throw new TaskNotFoundException(id);
		}
	
		taskService.deleteTask(id);
		
		return "redirect:/tasks";
	}
	
}
