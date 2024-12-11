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
import com.collaboration.edit.tool.collaboration_edit_tool.exception.validator.TaskValidator;
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

    public Task getTaskById(UUID id){
        return taskRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("task could not be found because id did not exist"));
    }

    public void postTask(TaskDTO taskBody){
        TaskValidator.validateTask(taskBody.taskId,taskBody.title,taskBody.description,taskBody.dueDate,taskBody.status,taskBody.taskGroupId);
        Task newTask = new Task();
        newTask.setTaskId(taskBody.taskId);
        newTask.setTitle(taskBody.title);
        newTask.setDescription(taskBody.description);
        newTask.setDueDate(taskBody.dueDate);
        newTask.setStatus(taskBody.status);
        Optional<TaskGroup> optionalTaskGroup = taskGroupRepo.findById(taskBody.taskGroupId);
        TaskGroup taskGroup = optionalTaskGroup.orElseThrow(()-> new ResourceNotFoundException("Task group not found"));
        newTask.setTaskGroup(taskGroup);
        taskGroup.setTask(newTask);
        taskGroupRepo.save(taskGroup);
    }

    public boolean updateTask(UUID id,TaskDTO taskBody){
        Optional<Task> optionalTask = taskRepo.findById(id);
        TaskValidator.validateTask(taskBody.taskId, taskBody.title, taskBody.description, taskBody.dueDate, taskBody.status, taskBody.taskGroupId);
        if(optionalTask.isPresent()){
            Task newTask = optionalTask.orElseThrow(()-> new ResourceNotFoundException("Unable to update task because id does not exist!"));
            newTask.setTitle(taskBody.title);
            newTask.setDescription(taskBody.description);
            newTask.setDueDate(taskBody.dueDate);
            newTask.setStatus(taskBody.status);
            Optional<TaskGroup> optionalTaskGroup = taskGroupRepo.findById(taskBody.taskGroupId);
            TaskGroup taskGroup = optionalTaskGroup.orElseThrow(()-> new ResourceNotFoundException("Unable to update task because the group id does not exist!"));
            newTask.setTaskGroup(taskGroup);
            taskRepo.save(newTask);
            return true;
        }
        return false;
    }

    public void deleteTask(UUID id){
        Optional<Task> optionalTask = taskRepo.findById(id);
        Task task = optionalTask.orElseThrow(()->new ResourceNotFoundException("Unable to delete task because id does not exist"));
        taskRepo.delete(task);
    }
}
