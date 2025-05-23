package org.devora.dto;

import lombok.Builder;

@Builder
public record CreateUserDto(
        String firstName,
        String lastName,
        String email,
        String username,
        String password,
        String passConfirm
) {
}