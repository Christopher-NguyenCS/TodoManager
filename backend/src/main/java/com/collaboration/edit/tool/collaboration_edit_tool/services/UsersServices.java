package com.collaboration.edit.tool.collaboration_edit_tool.services;


import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Users;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.UserRepository;
import com.collaboration.edit.tool.collaboration_edit_tool.model.UserDTO;

@Service
public class UsersServices {
    UserRepository userRepository;

    public UsersServices(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public void setUser(UserDTO body){
        Users newUser = new Users();
        newUser.setFirstName(body.firstName);
        newUser.setId(body.id);
        newUser.setLastName(body.lastName);
        newUser.setAccessType(body.accessType);
        userRepository.save(newUser);
    }

    public boolean updateUser(UUID id, UserDTO body){
        Optional<Users> optionalUsers = userRepository.findById(id);
        if(optionalUsers.isPresent()){
            Users newUser = optionalUsers.get();
            newUser.setId(id);
            newUser.setFirstName(body.firstName);
            newUser.setLastName(body.lastName);
            newUser.setAccessType(body.accessType);
            userRepository.save(newUser);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteUser(UUID id){
        if(userRepository.findById(id)!=null){
            userRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
