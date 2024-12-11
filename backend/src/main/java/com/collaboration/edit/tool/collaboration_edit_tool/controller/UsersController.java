package com.collaboration.edit.tool.collaboration_edit_tool.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.collaboration.edit.tool.collaboration_edit_tool.model.UserDTO;
import com.collaboration.edit.tool.collaboration_edit_tool.services.UsersServices;



@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequestMapping("/users")
public class UsersController {
    UsersServices usersServices;


    public UsersController(UsersServices usersServices){
        this.usersServices = usersServices;
    }

    
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(usersServices.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> getUser(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(usersServices.getUser(id), HttpStatus.OK);
    }
    
    @PostMapping(consumes="application/json")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userBody){
        usersServices.addUser(userBody);
        return new ResponseEntity<>("Data has been set up", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable(value="id") UUID id, @RequestBody UserDTO userBody) {
        usersServices.updateUser(id,userBody); 

        return new ResponseEntity<>("Successful update", HttpStatus.OK);
        
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeUser(@PathVariable UUID id){
        usersServices.deleteUser(id);
        return new ResponseEntity<>("Delete user successfully", HttpStatus.NO_CONTENT);
    }
}
