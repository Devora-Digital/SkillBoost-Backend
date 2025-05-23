package org.devora.dto;

import lombok.Builder;
import org.devora.enums.SocialLinkType;

@Builder
public record SocialLinkDto(
        SocialLinkType type,
        String url
) {
}
