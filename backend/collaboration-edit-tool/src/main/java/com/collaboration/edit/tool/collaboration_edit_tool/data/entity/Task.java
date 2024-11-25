package com.collaboration.edit.tool.collaboration_edit_tool.data.entity;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="task-id")
    private UUID taskId;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="due-date")
    private Date dueDate;
    @Column(name="status")
    private String status;
    @Column(name="group-id")
    private UUID groupId;

    public UUID getId(){
        return this.taskId;
    }
    public void setId(UUID taskId){
        this.taskId = taskId;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title =title;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description; 
    }
    public Date getDate(){
        return this.dueDate;
    }
    public void setDate(Date dueDate){
        this.dueDate = dueDate;
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public UUID getGroupId(UUID groupId){
        return this.groupId;
    }
    public void setGroupId(UUID groupId){
        this.groupId = groupId;
    }

}
