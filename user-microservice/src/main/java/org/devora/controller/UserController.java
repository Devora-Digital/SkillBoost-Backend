package org.devora.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devora.dto.SignUpRequest;
import org.devora.dto.UserResponse;
import org.devora.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestBody SignUpRequest signUpRequest) {
        var response = userService.createUser(signUpRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}