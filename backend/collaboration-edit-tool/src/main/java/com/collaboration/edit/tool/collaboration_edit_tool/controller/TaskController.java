package com.collaboration.edit.tool.collaboration_edit_tool.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Task;
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
}
