package com.cabras_corp.xproject.entrypoint.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
}
