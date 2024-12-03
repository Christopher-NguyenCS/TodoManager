package com.collaboration.edit.tool.collaboration_edit_tool.model;

import java.util.List;
import java.util.UUID;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Task;


public class TaskGroupDTO {

    public UUID groupId;
  
    public String groupTitle;
   
    public String groupDescription;

    public List<Task> tasks;
    
}
