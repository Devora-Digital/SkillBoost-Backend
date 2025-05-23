package org.devora.mapper;

import lombok.RequiredArgsConstructor;
import org.devora.dto.CreateUserDto;
import org.devora.dto.UpdateUserDto;
import org.devora.dto.UserDetailsDto;
import org.devora.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final SocialLinkMapper socialLinkMapper;

    public UserDetailsDto toDto(User entity) {
        return UserDetailsDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .role(entity.getRole())
                .headline(entity.getHeadline())
                .description(entity.getDescription())
                .language(entity.getLanguage())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .links(entity.getLinks() != null
                        ? entity.getLinks().stream()
                        .map(socialLinkMapper::toDto)
                        .toList()
                        : List.of()
                )
                .build();
    }

    public User toEntity(CreateUserDto dto) {
        return User.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .username(dto.username())
                .password(dto.password())
                .build();
    }

    public void fromDto(UpdateUserDto request, User user) {
        if (request.firstName() != null) {
            user.setFirstName(request.firstName());
        }

        if (request.lastName() != null) {
            user.setLastName(request.lastName());
        }

        if (request.headline() != null) {
            user.setHeadline(request.headline());
        }

        if (request.description() != null) {
            user.setDescription(request.description());
        }

        if (request.language() != null) {
            user.setLanguage(request.language());
        }

        if (request.links() != null) {
            user.getLinks().clear();

            var newLinks = request.links().stream()
                    .map(linkDto -> {
                        var link = socialLinkMapper.toEntity(linkDto);
                        link.setUser(user);
                        return link;
                    })
                    .toList();

            user.getLinks().addAll(newLinks);
        }
    }
}
