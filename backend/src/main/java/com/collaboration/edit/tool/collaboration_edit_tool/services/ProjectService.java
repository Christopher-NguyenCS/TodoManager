package com.collaboration.edit.tool.collaboration_edit_tool.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Project;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.ProjectRepository;
import com.collaboration.edit.tool.collaboration_edit_tool.exception.validator.ProjectValidator;
import com.collaboration.edit.tool.collaboration_edit_tool.model.ProjectDTO;

@Service
public class ProjectService {
    ProjectRepository projectRepository;
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project getProject(UUID id){
        return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project was not found because id did not exist"));
    }

    public void addProject(ProjectDTO projectBody){
        ProjectValidator.validateProject(projectBody.projectId, projectBody.projectTitle, projectBody.projectDescription);
        Project newProject = new Project();
        newProject.setProjectId(projectBody.projectId);
        newProject.setProjectDescription(projectBody.projectDescription);
        newProject.setProjectTitle(projectBody.projectTitle);
        projectRepository.save(newProject);
    }

    public boolean updateProject(UUID id, ProjectDTO projectBody){
        ProjectValidator.validateProject(id, projectBody.projectTitle, projectBody.projectDescription);
        Optional<Project> optionalProject = projectRepository.findById(id);
        if(optionalProject.isPresent()){
            Project project = optionalProject.orElseThrow(() -> new ResourceNotFoundException(String.format("Unable to update project %s because the id does not exist", projectBody.projectTitle)));
            project.setProjectDescription(projectBody.projectDescription);
            project.setProjectTitle(projectBody.projectTitle);
            projectRepository.save(project);
            return true;
        }
        return false;
    }

    public boolean deleteProject(UUID id){
        projectRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Unable to delete project because id does not exist"));
        projectRepository.deleteById(id);
        return true;
    } 
}
