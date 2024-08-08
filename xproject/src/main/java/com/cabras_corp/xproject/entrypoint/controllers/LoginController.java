package com.cabras_corp.xproject.entrypoint.controllers;

import com.cabras_corp.xproject.entrypoint.controllers.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path = "/{username}")
    public ResponseEntity<UserResponse> findByUsername(@RequestParam String username) {
        return "test";
    }

}
