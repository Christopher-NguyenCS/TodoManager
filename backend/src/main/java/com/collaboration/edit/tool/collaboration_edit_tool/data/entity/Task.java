package com.collaboration.edit.tool.collaboration_edit_tool.data.entity;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_id")
    private UUID taskId;
    
    @Column(name="task_group_id")
    private UUID groupId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "status")
    private String status;
    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private TaskGroup taskGroup;
    
    
        // Getters and setters
        public UUID getTaskId() {
            return taskId;
        }
    
        public void setTaskId(UUID taskId) {
            this.taskId = taskId;
        }

        public UUID getTaskGroupId(){
            return groupId;
        }

        public void setTaskGroupId(UUID groupId){
            this.groupId = groupId;
        }
    
        public String getTitle() {
            return title;
        }
    
        public void setTitle(String title) {
            this.title = title;
        }
    
        public String getDescription() {
            return description;
        }
    
        public void setDescription(String description) {
            this.description = description;
        }
    
        public Date getDueDate() {
            return dueDate;
        }
    
        public void setDueDate(Date dueDate) {
            this.dueDate = dueDate;
        }
    
        public String getStatus() {
            return status;
        }
    
        public void setStatus(String status) {
            this.status = status;
        }
    
        public TaskGroup getTaskGroup() {
            return taskGroup;
        }
    
        public void setTaskGroup(TaskGroup taskGroup) {
            this.taskGroup = taskGroup;
        }
        
        public UUID getGroupId(){
            return groupId;
        }
        public void setGroupId(UUID groupId) {
            this.groupId = groupId;
    }
}
