package com.collaboration.edit.tool.collaboration_edit_tool.exception.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.collaboration.edit.tool.collaboration_edit_tool.exception.EmptyFieldsException;

public class UserValidator {
        public static void validateUser(UUID id, String firstName,String lastName, String accessType){
        List<String> userErrors = new ArrayList<>();
        Optional<UUID> checkId = Optional.ofNullable(id);
        Optional<String> checkFirstName = Optional.ofNullable(firstName);
        Optional<String> checkLastName = Optional.ofNullable(lastName);
        Optional<String> checkAccessType = Optional.ofNullable(accessType);
        if(checkId.isEmpty()){
            userErrors.add("id is null");
        }
        if(checkFirstName.isEmpty()){
            userErrors.add("first name is null");
        }
        if(checkLastName.isEmpty()){
            userErrors.add("last name is null");
        }
        if(checkAccessType.isEmpty()){
            userErrors.add("access type is null");
        }
        if(userErrors.isEmpty()){
            return;
        }
        throw new EmptyFieldsException(userErrors);
        
    } 
}
