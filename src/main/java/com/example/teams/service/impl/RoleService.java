package com.example.teams.service.impl;

import com.example.teams.dtos.CreateRoleDto;
import com.example.teams.dtos.RoleDto;
import com.example.teams.entity.Role;
import com.example.teams.repository.RoleRepository;
import com.example.teams.service.IRoleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;

    public RoleService(RoleRepository roleRepository, ObjectMapper objectMapper) {
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public RoleDto create(CreateRoleDto createRoleDto) {
        Role role = this.objectMapper.convertValue(createRoleDto, Role.class);
        Role newRole = this.roleRepository.save(role);
        return objectMapper.convertValue(newRole,
                RoleDto.class
        );
    }

    @Override
    public List<RoleDto> getAll() {
        return this.roleRepository.findAll().stream().map((r)-> objectMapper.convertValue(r, RoleDto.class)).toList();
    }
}
