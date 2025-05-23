package org.devora.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devora.dto.CreateUserDto;
import org.devora.dto.UpdateUserDto;
import org.devora.dto.UserDetailsDto;
import org.devora.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserDetailsDto> register(@RequestBody CreateUserDto createUserDto) {
        var response = userService.createUser(createUserDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailsDto> updateUser(
            @PathVariable UUID id,
            @RequestBody UpdateUserDto request
    ) {
        var response = userService.updateUser(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}