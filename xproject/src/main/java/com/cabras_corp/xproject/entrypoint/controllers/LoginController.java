package com.cabras_corp.xproject.entrypoint.controllers;

import com.cabras_corp.xproject.core.domain.dtos.UserDTO;
import com.cabras_corp.xproject.entrypoint.controllers.dto.UserRequest;
import com.cabras_corp.xproject.core.services.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;


    @GetMapping()
    public ResponseEntity<Boolean> authenticate(@RequestBody @Valid UserRequest request) {
        boolean isAuthenticated = loginService.authenticate(UserDTO.toDTO(request));

        return ResponseEntity.ok(isAuthenticated);
    }

}
