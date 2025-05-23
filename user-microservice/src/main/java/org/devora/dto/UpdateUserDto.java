package org.devora.dto;

import lombok.Builder;
import org.devora.enums.Language;

import java.util.List;

@Builder
public record UpdateUserDto(
        String firstName,
        String lastName,
        String headline,
        String description,
        Language language,
        List<SocialLinkDto> links
) {
}
