
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task } from './task.model';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiurl:string="http://localhost:8080/api/tasks";

  constructor(private httpClient:HttpClient) { }

  createTask(newTask:Task):Observable<Task>{
    return this.httpClient.post<Task>(this.apiurl,newTask)
  }

  getAllTasks():Observable<Task[]>{
    return this.httpClient.get<Task[]>(this.apiurl);
  }

  UpdateTask(taskId:number,updatedTask:Task):Observable<Task>{
  return this.httpClient.put<Task>(this.apiurl+'/'+taskId,updatedTask)
  }
  deleteTask(taskId:number){

    return this.httpClient.delete(this.apiurl+'/'+taskId)
  }
}
