package org.devora.dto;

import lombok.Builder;
import org.devora.enums.Language;
import org.devora.enums.Role;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record UserDetailsDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String username,
        String password,
        Role role,
        String headline,
        String description,
        Language language,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<SocialLinkDto> links
) {
}