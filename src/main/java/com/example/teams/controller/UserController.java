package com.example.teams.controller;

import com.example.teams.dtos.CreateUserDto;
import com.example.teams.dtos.UserDto;
import com.example.teams.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(
            @RequestBody CreateUserDto createUserDto
    ) {
        return new ResponseEntity<>(
                this.iUserService.create(createUserDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> list(){
        return new ResponseEntity<>(
                this.iUserService.getAll(),
                HttpStatus.CREATED
        );
    }
}
