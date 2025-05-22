package org.devora.mapper;

import org.devora.dto.SignUpRequest;
import org.devora.dto.UserResponse;
import org.devora.enums.Language;
import org.devora.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

   User toEntity(SignUpRequest request);

   @Mapping(source = "language", target = "language", qualifiedByName = "mapLangToTitle")
   UserResponse toDto(User user);

   @Named("mapLangToTitle")
   default String mapLangToTitle(Language language) {
      return language != null ? language.getLabel() : null;
   }
}
