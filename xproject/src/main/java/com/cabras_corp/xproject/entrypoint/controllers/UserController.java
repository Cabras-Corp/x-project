package com.cabras_corp.xproject.entrypoint.controllers;

import com.cabras_corp.xproject.core.domain.dtos.UserDTO;
import com.cabras_corp.xproject.entrypoint.controllers.dto.UserRequest;
import com.cabras_corp.xproject.entrypoint.controllers.dto.UserResponse;
import com.cabras_corp.xproject.core.services.UserService;
import com.cabras_corp.xproject.utils.mapper.UserDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private UserDTOMapper mapper;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<UserResponse> createNewUser(@RequestBody @Valid UserRequest request) {
        UserDTO user = userService.create(request);
        return ResponseEntity.ok(mapper.toResponse(user));
    }

}
