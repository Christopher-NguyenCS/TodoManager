package com.collaboration.edit.tool.collaboration_edit_tool.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Users;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.UserRepository;
import com.collaboration.edit.tool.collaboration_edit_tool.exception.validator.UserValidator;
import com.collaboration.edit.tool.collaboration_edit_tool.model.UserDTO;

@Service
public class UsersServices {
    UserRepository userRepository;

    public UsersServices(UserRepository userRepository){
        this.userRepository = userRepository;
 
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users getUser(UUID id){
        Optional<Users> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(()-> new ResourceNotFoundException("Could not get the specific user because id does not exist."));
    }
    
    public void addUser(UserDTO body){
        UserValidator.validateUser(body.id, body.firstName, body.lastName, body.accessType);
        Users newUser = new Users();
        newUser.setFirstName(body.firstName);
        newUser.setId(body.id);
        newUser.setLastName(body.lastName);
        newUser.setAccessType(body.accessType);
        userRepository.save(newUser);
    }

    public void updateUser(UUID id, UserDTO body){
        UserValidator.validateUser(body.id,body.firstName,body.lastName,body.accessType);
        Optional<Users> optionalUsers = userRepository.findById(id);
        Users newUser = optionalUsers.orElseThrow(()-> new ResourceNotFoundException("Unable to update the user becuase the id does not exist."));
        newUser.setId(id);
        newUser.setFirstName(body.firstName);
        newUser.setLastName(body.lastName);
        newUser.setAccessType(body.accessType);
        userRepository.save(newUser);
    }

    public void deleteUser(UUID id){
        Optional<Users> optionalUser = userRepository.findById(id);
        Users user = optionalUser.orElseThrow(() -> new ResourceNotFoundException("Unable to delete the user because the id does not exist"));
        userRepository.delete(user);
    }
}
