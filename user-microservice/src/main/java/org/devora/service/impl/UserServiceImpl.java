package org.devora.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devora.dto.CreateUserDto;
import org.devora.dto.UpdateUserDto;
import org.devora.dto.UserDetailsDto;
import org.devora.exception.UserNotFoundException;
import org.devora.mapper.UserMapper;
import org.devora.repository.UserRepository;
import org.devora.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetailsDto createUser(CreateUserDto createUserDto) {
        var user = userMapper.toEntity(createUserDto);
        var savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }

    @Override
    @Transactional
    public UserDetailsDto updateUser(UUID userId, UpdateUserDto request) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found by id: " + userId));

        userMapper.fromDto(request, user);
        var savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }
}
