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
    
    public void importUserData(UserDTO body){
        Users newUser = new Users();
        newUser.setFirstName(body.firstName);
        newUser.setId(body.id);
        newUser.setLastName(body.lastName);
        newUser.setAccessType(body.accessType);
        userRepository.save(newUser);
    }
    public boolean updateUser(UUID id, UserDTO body){
        Users updateUser = new Users();
       
        if(userRepository.findById(id) != null){
            updateUser.setId(id);
            updateUser.setFirstName(body.firstName);
            updateUser.setLastName(body.lastName);
            updateUser.setAccessType(body.accessType);
            userRepository.save(updateUser);
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
