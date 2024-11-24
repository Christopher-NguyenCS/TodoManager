package com.collaboration.edit.tool.collaboration_edit_tool.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class Users {
    @Id
    @Column(name="user-id")
    private long id;
    @Column(name="first-name")
    private String firstName;
    @Column(name="last-name")
    private String lastName;
    @Column(name="access-type")
    private String accessType;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
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
