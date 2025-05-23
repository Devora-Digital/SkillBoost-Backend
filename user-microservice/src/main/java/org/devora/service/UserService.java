package org.devora.service;

import org.devora.dto.CreateUserDto;
import org.devora.dto.UpdateUserDto;
import org.devora.dto.UserDetailsDto;

import java.util.UUID;

public interface UserService {
    UserDetailsDto createUser(CreateUserDto createUserDto);

    UserDetailsDto updateUser(UUID id, UpdateUserDto request);
}
