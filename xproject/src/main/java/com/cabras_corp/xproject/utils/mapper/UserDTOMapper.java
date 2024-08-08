package com.cabras_corp.xproject.utils.mapper;

import com.cabras_corp.xproject.core.domain.dtos.UserDTO;
import com.cabras_corp.xproject.core.domain.entities.User;
import com.cabras_corp.xproject.entrypoint.controllers.dto.UserRequest;
import com.cabras_corp.xproject.entrypoint.controllers.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserDTOMapper {

    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.password", target = "password")
     UserDTO toDTO(UserRequest request);

    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.password", target = "password")
    UserDTO toDTO(User user);

    @Mapping(source = "user.username", target = "username")
    UserResponse toResponse(UserDTO user);

}
