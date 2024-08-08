package com.cabras_corp.xproject.core.domain.dtos;

import com.cabras_corp.xproject.core.domain.entities.User;
import com.cabras_corp.xproject.entrypoint.controllers.dto.UserRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserDTO(@NotNull @NotBlank String username, String password) {
    public static UserDTO toDTO(@NotNull @Valid UserRequest request) {
        return UserDTO.builder()
                .username(request.username())
                .password(request.password())
                .build();
    }

    public static UserDTO toDTO(@NotNull @Valid User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

}
