package com.collaboration.edit.tool.collaboration_edit_tool.exception.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.collaboration.edit.tool.collaboration_edit_tool.exception.EmptyFieldsException;

public class ProjectValidator {
    public static void validateProject(UUID id, String title, String description){
        List<String> projectErrors = new ArrayList<>();
        Optional<UUID> checkId = Optional.ofNullable(id);
        Optional<String> checkTitle = Optional.ofNullable(title);
        Optional<String> checkDescription = Optional.ofNullable(description);
        if(checkId.isEmpty()){
            projectErrors.add("id is null");
        }
        if(checkTitle.isEmpty()){
            projectErrors.add("title is null");
        }
         if(checkDescription.isEmpty()){
            projectErrors.add("description is null");
        }
        if(projectErrors.isEmpty()){
            return;
        }
        throw new EmptyFieldsException(projectErrors);
    }

}
