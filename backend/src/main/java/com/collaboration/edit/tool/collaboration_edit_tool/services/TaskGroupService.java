package com.collaboration.edit.tool.collaboration_edit_tool.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.TaskGroup;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.TaskGroupRepository;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.TaskRepository;
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

    public Optional<TaskGroup> getTaskGroup(UUID id) {
        return taskGroupRepository.findById(id);  
    }

    public void addTaskGroup(TaskGroupDTO taskGroupBody) {
        TaskGroup newTaskGroup = new TaskGroup();
        newTaskGroup.setGroupId(taskGroupBody.groupId);
        newTaskGroup.setGroupTitle(taskGroupBody.groupTitle);
        newTaskGroup.setGroupDescription(taskGroupBody.groupDescription);
        taskGroupRepository.save(newTaskGroup);
    }

    public boolean updateTaskGroup(UUID id, TaskGroupDTO taskGroupBody){
        Optional<TaskGroup> optionalTaskGroup = taskGroupRepository.findById(id);
        if(optionalTaskGroup.isPresent()){
            TaskGroup taskGroup = optionalTaskGroup.get();
            taskGroup.setGroupDescription(taskGroupBody.groupDescription);
            taskGroup.setGroupTitle(taskGroupBody.groupTitle);
            return true;
        }
        return false;
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
