
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Task } from './task.model';
import { TaskService } from './task.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-task',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './task.component.html',
  styleUrl: './task.component.css'
})
export class TaskComponent implements OnInit {

  constructor(private taskservice:TaskService){}

  newTask:Task={
    description:"",completed:false
  };
  tasks:Task[]=[];//initial value
  editingTask:Task|null=null;
  updatedTask:Task={
    description:"",completed:false
  };

  ngOnInit(): void {
      this.getAllTasks();
  }


  createTask():void{
    this.taskservice.createTask(this.newTask).subscribe((createdtask)=>{
      this.newTask={description:"",completed:false};//reset task
      this.tasks.push(createdtask)
    })
 }
 getAllTasks(){
  this.taskservice.getAllTasks().subscribe((taskss)=>{
    this.tasks=taskss
  })
}

editTask(taskk:Task){
  this.editingTask=taskk;
  this.updatedTask={...taskk};//create a copy for edit


}
updateTask():void{
  if(this.editingTask){
    this.taskservice.UpdateTask(this.editingTask.id!,this.updatedTask).subscribe((result)=>{
      const index= this.tasks.findIndex((val)=> val.id == this.editingTask!.id)
      console.log("num",index);
        if (index !== -1){
          this.tasks[index]=result;
          //close edit
          this.cancelEdit()
        }


      })

    }
  }
  cancelEdit(){
    this.editingTask=null;
    this.updatedTask={description:"",completed:false};
  }


  deleteTask(taskId:any){
    if(confirm('Are you sure you want to delete the Task'))
    this.taskservice.deleteTask(taskId).subscribe(()=>{
      

      this.tasks = this.tasks.filter(task => task.id !== taskId);
       if(this.editingTask && this.editingTask.id == taskId)
        {
          this.cancelEdit();

       }
      })
    } 
}
