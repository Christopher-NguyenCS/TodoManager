package com.collaboration.edit.tool.collaboration_edit_tool.exception.validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.collaboration.edit.tool.collaboration_edit_tool.exception.EmptyFieldsException;

public class TaskValidator {
        public static void validateTask(UUID id, String title, String description, Date dueDate, String status,UUID groupId){
        List<String> taskErrors = new ArrayList<>();
        Optional<UUID> checkId = Optional.ofNullable(id);
        Optional<String> checkTitle = Optional.ofNullable(title);
        Optional<String> checkDescription = Optional.ofNullable(description);
        Optional<Date> checkDueDate = Optional.ofNullable(dueDate);
        Optional<String> checkStatus = Optional.ofNullable(status);
        Optional<UUID> checkGroupId = Optional.ofNullable(groupId);
        if(checkId.isEmpty()){
            taskErrors.add("id is null");
        }
         if(checkTitle.isEmpty()){
            taskErrors.add("title is null");
        }
         if(checkDescription.isEmpty()){
            taskErrors.add("description is null");
        }
         if(checkDueDate.isEmpty()){
            taskErrors.add("due date is null");
        }
         if(checkStatus.isEmpty()){
            taskErrors.add("status is null");
        }
         if(checkGroupId.isEmpty()){
            taskErrors.add("group id is null");
        }
        if(taskErrors.isEmpty()){
            return;
        }
        throw new EmptyFieldsException(taskErrors);
    }
}
