package com.hcl.taskmanager.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public String createNewTaskForm(Model model) {
		Task newTask = new Task();
		model.addAttribute("newTask", newTask);
		
		return "create-new-task";
	}
	
	@PostMapping("/save-task")
	public String saveNewTask(@ModelAttribute("newTask") Task newTask) throws ParseException {
		taskService.addTask(newTask);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit-task/{id}")
	public ModelAndView editTaskForm(@PathVariable(name = "id") long id) {
		ModelAndView mv = new ModelAndView("edit-task");
		Task task = taskService.getSingleTask(id);
		mv.addObject("task", task);
		
		return mv;
	}
	
	@PostMapping("/update-task")
	public String updateTask(@ModelAttribute(name = "task") Task updatedTask) {
		taskService.updateTask(updatedTask.getId(), updatedTask);;
		
		return "redirect:/";
	}
	
	
	
}
