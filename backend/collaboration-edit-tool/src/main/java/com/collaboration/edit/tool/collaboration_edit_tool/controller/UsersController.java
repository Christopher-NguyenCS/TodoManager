package com.collaboration.edit.tool.collaboration_edit_tool.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Users;
import com.collaboration.edit.tool.collaboration_edit_tool.data.repository.UserRepository;
import com.collaboration.edit.tool.collaboration_edit_tool.model.UserDTO;
import com.collaboration.edit.tool.collaboration_edit_tool.services.UsersServices;



@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequestMapping("/users")
public class UsersController {
    UserRepository userRepository;
    UsersServices usersServices;


    public UsersController(UserRepository userRepository,UsersServices usersServices){
        this.userRepository = userRepository;
        this.usersServices = usersServices;
    }

    
    @GetMapping
    public List<Users> getUsers() {
        
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Users> getUser(@PathVariable UUID id) {
        return userRepository.findById(id);
    }
    
    @PostMapping(consumes="application/json")
    public String setUser(@RequestBody UserDTO userBody){
        if(userBody.toString().isEmpty()){
            return "inefficient data";
        }
        usersServices.importUserData(userBody);
        return "Data has been set up";
    }
    @PutMapping("/{id}")
    public String putMethodName(@PathVariable UUID id, @RequestBody UserDTO userBody) {
        boolean check = usersServices.updateUser(id,userBody);
        if(check){
            return "Successful update";
        }
        else{
            return "Could not update";
        }
    }

    @DeleteMapping("{id}")
    public String removeUser(@PathVariable UUID id){
        boolean check = usersServices.deleteUser(id);
        if(check == true){
            return "deleted user";
        }
        return "could not delete";
    }
    



}
