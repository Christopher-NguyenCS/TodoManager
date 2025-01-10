package com.collaboration.edit.tool.collaboration_edit_tool.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collaboration.edit.tool.collaboration_edit_tool.data.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

}
