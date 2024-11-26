package com.collaboration.edit.tool.collaboration_edit_tool.data.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

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

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
