package com.collaboration.edit.tool.collaboration_edit_tool.services;

import java.util.List;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Task;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.TaskRepository;

public class TaskService {
    TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks(){
        return taskRepo.findAll();
        

    }
}
