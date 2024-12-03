package com.collaboration.edit.tool.collaboration_edit_tool.exception.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.collaboration.edit.tool.collaboration_edit_tool.exception.EmptyFieldsException;

public class TaskGroupValidator {
    public static void validateTaskGroup(UUID id, String title, String description){
        List<String> taskGroupErrors = new ArrayList<>();
        Optional<UUID> checkId = Optional.ofNullable(id);
        Optional<String> checkTitle = Optional.ofNullable(title);
        Optional<String> checkDescription = Optional.ofNullable(description);
        if(checkId.isEmpty()){
            taskGroupErrors.add("id is null");
        }
        if(checkTitle.isEmpty()){
            taskGroupErrors.add("title is null");
        }
         if(checkDescription.isEmpty()){
            taskGroupErrors.add("description is null");
        }
        if(taskGroupErrors.isEmpty()){
            return;
        }
        throw new EmptyFieldsException(taskGroupErrors);
    }
}
