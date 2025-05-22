package org.devora.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devora.dto.SignUpRequest;
import org.devora.dto.UserResponse;
import org.devora.mapper.UserMapper;
import org.devora.repository.UserRepository;
import org.devora.service.UserService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(SignUpRequest signUpRequest) {
        var user = userMapper.toEntity(signUpRequest);
        var savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }
}
