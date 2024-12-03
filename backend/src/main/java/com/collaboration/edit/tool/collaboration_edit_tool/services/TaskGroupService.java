package com.collaboration.edit.tool.collaboration_edit_tool.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.TaskGroup;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.TaskGroupRepository;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.TaskRepository;
import com.collaboration.edit.tool.collaboration_edit_tool.exception.validator.TaskGroupValidator;
import com.collaboration.edit.tool.collaboration_edit_tool.model.TaskGroupDTO;

@Service
public class TaskGroupService {
    TaskGroupRepository taskGroupRepository;
    TaskRepository taskRepository;


    public TaskGroupService(TaskGroupRepository taskGroupRepository, TaskRepository taskRepository){
        this.taskGroupRepository = taskGroupRepository;
        this.taskRepository = taskRepository;

    }

    public List<TaskGroup> getAllTaskGroups() {
        return taskGroupRepository.findAll();
    }

    public TaskGroup getTaskGroup(UUID id) {
        return taskGroupRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task Group was not found because id did not exist"));
    }

    public void addTaskGroup(TaskGroupDTO taskGroupBody) {
        TaskGroupValidator.validateTaskGroup(taskGroupBody.groupId, taskGroupBody.groupDescription, taskGroupBody.groupTitle);
        TaskGroup newTaskGroup = new TaskGroup();
        newTaskGroup.setGroupId(taskGroupBody.groupId);
        newTaskGroup.setGroupTitle(taskGroupBody.groupTitle);
        newTaskGroup.setGroupDescription(taskGroupBody.groupDescription);
        taskGroupRepository.save(newTaskGroup);
    }

    public void updateTaskGroup(UUID id, TaskGroupDTO taskGroupBody){
       TaskGroupValidator.validateTaskGroup(taskGroupBody.groupId, taskGroupBody.groupDescription, taskGroupBody.groupTitle);
        Optional<TaskGroup> optionalTaskGroup = taskGroupRepository.findById(id);
        TaskGroup taskGroup = optionalTaskGroup.orElseThrow(()-> new ResourceNotFoundException("Unable to update taskGroup because id did not exist."));
        taskGroup.setGroupDescription(taskGroupBody.groupDescription);
        taskGroup.setGroupTitle(taskGroupBody.groupTitle);
        taskGroupRepository.save(taskGroup);
    }

    public void deleteTaskGroup(UUID id) {
         if(taskGroupRepository.findById(id)!= null){
            while(taskRepository.existsById(id)){
                taskRepository.deleteById(id);
            }
            taskGroupRepository.deleteById(id);
         }
    }

}
