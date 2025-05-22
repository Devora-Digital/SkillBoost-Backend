package org.devora.dto;

import lombok.Builder;
import org.devora.model.UserLink;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record UserResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String username,
        String password,
        String role,
        String headline,
        String description,
        String language,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<UserLink> links
) {
}