package com.collaboration.edit.tool.collaboration_edit_tool.data.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Users;


public interface UserRepository extends JpaRepository<Users,UUID>{

}
