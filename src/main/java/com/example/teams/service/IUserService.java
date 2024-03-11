package com.example.teams.service;

import com.example.teams.dtos.CreateUserDto;
import com.example.teams.dtos.UserDto;

import java.util.List;

public interface IUserService {
    public UserDto create(CreateUserDto createUserDto);
    public List<UserDto> getAll();
}
