package org.devora.mapper;

import org.devora.dto.SocialLinkDto;
import org.devora.model.SocialLink;
import org.springframework.stereotype.Component;

@Component
public class SocialLinkMapper {

    SocialLinkDto toDto(SocialLink entity) {
        return SocialLinkDto.builder()
                .url(entity.getUrl())
                .type(entity.getType())
                .build();
    }

    SocialLink toEntity(SocialLinkDto dto) {
        return SocialLink.builder()
                .url(dto.url())
                .type(dto.type())
                .build();
    }
}
