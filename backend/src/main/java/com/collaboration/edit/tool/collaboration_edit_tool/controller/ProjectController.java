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

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Project;
import com.collaboration.edit.tool.collaboration_edit_tool.model.ProjectDTO;
import com.collaboration.edit.tool.collaboration_edit_tool.services.ProjectService;



@RestController
@CrossOrigin(origins="http://localhost:5173/")
@RequestMapping("/project")
public class ProjectController {
    ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }
    
    @GetMapping
    public ResponseEntity<List<Project>>getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable(value = "id")UUID id) {
        Project project = projectService.getProject(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
    
    @PostMapping(consumes="application/json")
    public ResponseEntity<String> addProject(@RequestBody ProjectDTO projectBody){
        projectService.addProject(projectBody);
        return new ResponseEntity<>(String.format("successfully added %s", projectBody.projectTitle), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProject(@PathVariable(value="id") UUID id, @RequestBody ProjectDTO projectBody) {

        if(projectService.updateProject(id, projectBody)){
            return new ResponseEntity<>(String.format("Updated project %s", projectBody.projectTitle), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(String.format("Not able to update project %s", projectBody.projectTitle), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable(value="id") UUID id){
        if(projectService.deleteProject(id)){
            return new ResponseEntity<>("Deleted project", HttpStatus.OK);
        }
        return new ResponseEntity<>("Could not delete project because id did not exist", HttpStatus.BAD_REQUEST);
    }
}
