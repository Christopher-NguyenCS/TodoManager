package com.collaboration.edit.tool.collaboration_edit_tool.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Task>> getAllTasks(){
        
        return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable(value = "id") UUID id){
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping(consumes="application/json")
    public ResponseEntity<String> addTask(@RequestBody TaskDTO taskBody){
        taskService.postTask(taskBody);
        return new ResponseEntity<>("successfully added task", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putTask(@PathVariable(value="id") UUID id, @RequestBody TaskDTO taskBody){
        if(taskService.updateTask(id, taskBody) )
        {
            return new ResponseEntity<>("Able to update task", HttpStatus.OK);
        }
        return new ResponseEntity<>("Unable to update task",HttpStatus.BAD_REQUEST);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeTask(@PathVariable UUID id){
        taskService.deleteTask(id);
        return new ResponseEntity<>("Task has been deleted", HttpStatus.NO_CONTENT);
    }
}
