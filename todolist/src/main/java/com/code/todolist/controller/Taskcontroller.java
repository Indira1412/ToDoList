package com.code.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.todolist.model.Task;
import com.code.todolist.repository.TaskRepo;

@RequestMapping("/api/tasks")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Taskcontroller {
	@Autowired
	private TaskRepo taskrepo;
	
	
	@GetMapping("/hello-world")
	public String hello() {
		return"good morning";
	}
	@PostMapping
	public Task createTask(@RequestBody Task task) {
	//	System.out.println(task.getDescription()+"-"+task.isCompleted());
		taskrepo.save(task);
		return task;
//		List<String> users= new ArrayList<>();
//		users.add("indhu");
//		users.add("devi");
//		return users;
	}
	@GetMapping
	public List<Task> getAllTasks() {
		return taskrepo.findAll();
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id,@RequestBody Task task) {
		task.setId(id);
		return taskrepo.save(task);
		
		
	}
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskrepo.deleteById(id);
		//return "deleted";
		
	}

}

