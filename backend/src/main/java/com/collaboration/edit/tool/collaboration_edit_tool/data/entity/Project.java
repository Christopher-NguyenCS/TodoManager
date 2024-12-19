package com.collaboration.edit.tool.collaboration_edit_tool.data.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "project_id")
    private UUID projectId;
    
    @Column(name = "project_title")
    private String projectTitle;

    @Column(name = "project_description")
    private String projectDescription;

    @OneToMany(mappedBy="project",cascade=CascadeType.ALL, orphanRemoval=true)
    List<TaskGroup> taskGroup;

 // Getter and Setter for projectId
    public UUID getProjectId() {
        return this.projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    // Getter and Setter for projectTitle
    public String getProjectTitle() {
        return this.projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    // Getter and Setter for projectDescription
    public String getProjectDescription() {
        return this.projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    // Getter and Setter for taskGroup
    public List<TaskGroup> getTaskGroup() {
        return this.taskGroup;
    }

    public void setTaskGroup(List<TaskGroup> taskGroup) {
        this.taskGroup = taskGroup;
    }
}
