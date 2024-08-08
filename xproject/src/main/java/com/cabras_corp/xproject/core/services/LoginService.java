package com.cabras_corp.xproject.core.services;

import com.cabras_corp.xproject.core.domain.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserService userService;

    public boolean authenticate(UserDTO user) {
        return true;
    }
}
