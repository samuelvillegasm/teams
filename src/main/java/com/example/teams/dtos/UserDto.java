package com.example.teams.dtos;

import com.example.teams.entity.Role;

import java.time.LocalDate;

public record UserDto (
        Long id,
        String name,
        String email,
        Role role
){
}
