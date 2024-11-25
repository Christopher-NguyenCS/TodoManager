package com.collaboration.edit.tool.collaboration_edit_tool.model;

import java.sql.Date;
import java.util.UUID;

public class TaskDTO {
    
    public UUID taskId;
    
    public String title;
    
    public String description;
    
    public Date dueDate;
    
    public String status;
    
    public UUID groupId;
}
