package org.devora.service;

import org.devora.dto.CreateUserDto;
import org.devora.dto.UpdateUserDto;
import org.devora.dto.UserDetailsDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserService {
    UserDetailsDto createUser(CreateUserDto createUserDto);

    UserDetailsDto updateUser(UUID id, UpdateUserDto request);

    Page<UserDetailsDto> getAllUsers(int page, int size);

    UserDetailsDto getUser(UUID id);

    void deleteUser(UUID id);
}
