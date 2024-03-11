package com.example.teams.service;

import com.example.teams.dtos.CreateRoleDto;
import com.example.teams.dtos.RoleDto;
import org.apache.catalina.Role;

import java.util.List;

public interface IRoleService {
    RoleDto create(CreateRoleDto createRoleDto);
    List<RoleDto> getAll();
}
