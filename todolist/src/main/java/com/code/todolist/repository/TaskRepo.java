package com.code.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.code.todolist.model.Task;

public interface TaskRepo extends  JpaRepository <Task,Long>{
	
	

}
