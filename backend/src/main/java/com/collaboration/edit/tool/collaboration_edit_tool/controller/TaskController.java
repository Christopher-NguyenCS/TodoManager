package com.collaboration.edit.tool.collaboration_edit_tool.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Task;
import com.collaboration.edit.tool.collaboration_edit_tool.model.TaskDTO;
import com.collaboration.edit.tool.collaboration_edit_tool.services.TaskService;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable UUID id){
        return taskService.getTaskById(id);
    }
    @PostMapping(consumes="application/json")
    public String addTask(@RequestBody TaskDTO taskBody){
        if(taskBody != null){
            taskService.postTask(taskBody);
            
            return "successfully added task";

        }
        return "unable to add task";
    }
    @PutMapping("/{id}")
    public String putTask(@PathVariable UUID id, TaskDTO taskBody){
        if(taskService.updateTask(id, taskBody) )
        {
            return "Able to update task";
        }
        return "Unable to update task";
        
    }
    @DeleteMapping("/{id}")
    public String removeTask(@PathVariable UUID id){
        if(taskService.deleteTask(id)){
            return "Task deleted";
        }
        return "Task does not exist, thus can not be deleted";
    }
}
