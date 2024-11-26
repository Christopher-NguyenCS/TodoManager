package com.collaboration.edit.tool.collaboration_edit_tool.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Task;
import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.TaskGroup;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.TaskGroupRepository;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.TaskRepository;
import com.collaboration.edit.tool.collaboration_edit_tool.model.TaskDTO;

@Service
public class TaskService {
    TaskRepository taskRepo;
    TaskGroupRepository taskGroupRepo;

    public TaskService(TaskRepository taskRepo, TaskGroupRepository taskGroupRepo){
        this.taskRepo = taskRepo;
        this.taskGroupRepo = taskGroupRepo;
    }

    public List<Task> getAllTasks(){
        return taskRepo.findAll();       
    }

    public Optional<Task> getTaskById(UUID id){
        return taskRepo.findById(id);
    }

    public void postTask(TaskDTO taskBody){
        Task newTask = new Task();
        newTask.setTaskId(taskBody.taskId);
        newTask.setTitle(taskBody.title);
        newTask.setDescription(taskBody.description);
        newTask.setDueDate(taskBody.dueDate);
        newTask.setStatus(taskBody.status);
        newTask.setGroupId(taskBody.groupId);
        Optional<TaskGroup> optionalTaskGroup = taskGroupRepo.findById(taskBody.groupId);
        TaskGroup taskGroup = optionalTaskGroup.orElseThrow(()-> new ResourceNotFoundException("Task group not found"));
        newTask.setTaskGroup(taskGroup);
        taskRepo.save(newTask);
    }

    public boolean updateTask(UUID id,TaskDTO taskBody){
        if(taskRepo.findById(id) != null){
            Task newTask = new Task();
            newTask.setTaskId(taskBody.taskId);
            newTask.setTitle(taskBody.title);
            newTask.setDescription(taskBody.description);
            newTask.setDueDate(taskBody.dueDate);
            newTask.setStatus(taskBody.status);
            newTask.setGroupId(taskBody.groupId);
            taskRepo.save(newTask);
            return true;
        }
        return false;
    }

    public boolean deleteTask(UUID id){
        if(taskRepo.findById(id) != null){
            taskRepo.deleteById(id);
            return true;
        }
        return false;
        
    }
}
