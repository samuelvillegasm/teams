package com.example.teams.service.impl;

import com.example.teams.dtos.CreateUserDto;
import com.example.teams.dtos.UserDto;
import com.example.teams.entity.Role;
import com.example.teams.entity.User;
import com.example.teams.repository.RoleRepository;
import com.example.teams.repository.UserRepository;
import com.example.teams.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserService(RoleRepository roleRepository, UserRepository userRepository, ObjectMapper objectMapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserDto create(CreateUserDto createUserDto) {
        Optional<Role> role = this.roleRepository.findById(createUserDto.roleId());
        if (role.isEmpty())
            throw new RuntimeException("Role not found");
        User user = objectMapper.convertValue(createUserDto, User.class);
        user.setRole(role.get());
        User newUser = this.userRepository.save(user);
        return new UserDto(newUser.getId(), newUser.getName(), newUser.getEmail(), newUser.getCreatedAt(), newUser.getUpdatedAt(), newUser.getRole());
    }

    @Override
    public List<UserDto> getAll() {
        return this.userRepository.findAll().stream().map((u) ->
                new UserDto(u.getId(), u.getName(), u.getEmail(), u.getCreatedAt(), u.getUpdatedAt(), u.getRole())
        ).toList();
    }
}
