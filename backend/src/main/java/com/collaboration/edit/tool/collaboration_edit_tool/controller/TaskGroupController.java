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

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.TaskGroup;
import com.collaboration.edit.tool.collaboration_edit_tool.model.TaskGroupDTO;
import com.collaboration.edit.tool.collaboration_edit_tool.services.TaskGroupService;

@CrossOrigin(origins="http://localhost:5173/")
@RequestMapping("/taskGroup")
@RestController
public class TaskGroupController {
    TaskGroupService taskGroupService;

    public TaskGroupController(TaskGroupService taskGroupService){
        this.taskGroupService = taskGroupService;
    }

    @GetMapping
    public List<TaskGroup> getAllTaskGroups(){
        return taskGroupService.getAllTaskGroups();
    }

    @GetMapping("/{id}")
    public Optional<TaskGroup> getTaskGroup(@PathVariable UUID id){
        return taskGroupService.getTaskGroup(id);
    }

    @PostMapping
    public String addTaskGroup(@RequestBody TaskGroupDTO taskGroupBody){
        if(taskGroupBody != null){
            taskGroupService.addTaskGroup(taskGroupBody);
            return "Added task group";
        }
        return "Unable to add task group";
    }

    @PutMapping("/{id}")
    public String updateTaskGroup(@PathVariable(value="id") UUID id, @RequestBody TaskGroupDTO taskGroupBody){
        if(taskGroupBody!= null){
            if(taskGroupService.updateTaskGroup(id, taskGroupBody)){
                return "Updated Task Group";
            }
            else{
                return"Unable to update Task group because the id did not exist.";
            }
        }
        return "Unable to update Task Group because taskGroupBody was null";
    }
    
    @DeleteMapping("/{id}")
    public String deleteTaskGroup(@PathVariable UUID id){
        taskGroupService.deleteTaskGroup(id);
        return "deleted task group";
    }
}
