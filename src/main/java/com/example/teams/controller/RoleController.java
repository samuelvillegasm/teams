package com.example.teams.controller;

import com.example.teams.dtos.CreateRoleDto;
import com.example.teams.dtos.RoleDto;
import com.example.teams.service.IRoleService;
import com.example.teams.service.impl.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private final IRoleService iRoleService;

    public RoleController(IRoleService iRoleService) {
        this.iRoleService = iRoleService;
    }

    @PostMapping
    public ResponseEntity<RoleDto> create(
            @RequestBody CreateRoleDto createRoleDto
    ) {
        return new ResponseEntity<RoleDto>(
                this.iRoleService.create(createRoleDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAll(
    ) {
        return new ResponseEntity<List<RoleDto>>(
                this.iRoleService.getAll(),
                HttpStatus.OK
        );
    }
}
