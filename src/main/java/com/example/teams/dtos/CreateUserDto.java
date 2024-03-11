package com.example.teams.dtos;

public record CreateUserDto(
        String name,
        String email,
        Long roleId
) {
}
