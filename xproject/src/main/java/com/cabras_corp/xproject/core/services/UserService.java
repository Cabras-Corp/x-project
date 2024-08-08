package com.cabras_corp.xproject.core.services;

import com.cabras_corp.xproject.core.domain.dtos.UserDTO;
import com.cabras_corp.xproject.entrypoint.controllers.dto.UserRequest;
import com.cabras_corp.xproject.core.domain.entities.User;
import com.cabras_corp.xproject.infra.repositories.UserRepository;
import com.cabras_corp.xproject.utils.mapper.UserDTOMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class UserService {

    private final UserRepository userRepository;
    private UserDTOMapper mapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDTO create(UserRequest user) {
        if(isNull(user)) throw new IllegalArgumentException("User cannot be null");

        User userToSave = new User();
        userToSave.setUsername(user.username());
        userToSave.setPassword(user.password());

        User saved = userRepository.save(userToSave);

        return mapper.toDTO(saved);
    }

    public UserDTO findByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if(userOptional.isEmpty()) throw new EntityNotFoundException("User not found");

        return UserDTO.toDTO(userOptional.get());
    }

}
