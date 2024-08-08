package com.cabras_corp.xproject.entrypoint.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserResponse(@NotNull @NotBlank String username) {
}
