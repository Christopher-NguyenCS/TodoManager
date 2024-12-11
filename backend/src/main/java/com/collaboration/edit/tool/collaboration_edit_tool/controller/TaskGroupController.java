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
    public ResponseEntity<List<TaskGroup>> getAllTaskGroups(){
        return new ResponseEntity<>(taskGroupService.getAllTaskGroups(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskGroup> getTaskGroup(@PathVariable(value = "id") UUID id){
        return new ResponseEntity<>(taskGroupService.getTaskGroup(id), HttpStatus.OK);
    }

    @PostMapping(consumes="application/json")
    public ResponseEntity<String> addTaskGroup(@RequestBody TaskGroupDTO taskGroupBody){
        taskGroupService.addTaskGroup(taskGroupBody);
        return new ResponseEntity<>("Added task group", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTaskGroup(@PathVariable(value="id") UUID id, @RequestBody TaskGroupDTO taskGroupBody){       
        taskGroupService.updateTaskGroup(id, taskGroupBody);
        return new ResponseEntity<>("Updated Task Group", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskGroup(@PathVariable(value = "id") UUID id){
        taskGroupService.deleteTaskGroup(id);
        return new ResponseEntity<>("deleted task group", HttpStatus.NO_CONTENT);
    }
}
