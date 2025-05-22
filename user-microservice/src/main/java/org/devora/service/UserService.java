package org.devora.service;

import org.devora.dto.SignUpRequest;
import org.devora.dto.UserResponse;

public interface UserService {
    UserResponse createUser(SignUpRequest signUpRequest);
}
