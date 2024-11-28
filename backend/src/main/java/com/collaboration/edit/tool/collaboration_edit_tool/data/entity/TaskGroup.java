package com.collaboration.edit.tool.collaboration_edit_tool.data.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_group")  
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "group_id") 
    private UUID groupId;

    @Column(name = "group_title")
    private String groupTitle;

    @Column(name = "group_description")
    private String groupDescription;

    @OneToMany(mappedBy = "taskGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Task> tasks;

    // Getters and setters
    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTask(Task task) {
        tasks.add(task);
    }
}
