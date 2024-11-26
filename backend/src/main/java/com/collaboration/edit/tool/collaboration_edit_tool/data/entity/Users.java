package com.collaboration.edit.tool.collaboration_edit_tool.data.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class Users {
    @Id
    @Column(name="user_id")
    private UUID id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="access_type")
    private String accessType;

    public UUID getId(){
        return id;
    }
    public void setId(UUID id2){
        this.id = id2;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getAccessType(){
        return accessType;
    }
    public void setAccessType(String accessType){
        this.accessType = accessType;
    }

    public void displayUser(){
        System.out.print(id + "\n"+firstName+ "\n"+lastName+ "\n"+accessType+ "\n");
    }

}
