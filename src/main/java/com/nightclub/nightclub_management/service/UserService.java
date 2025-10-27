package com.nightclub.nightclub_management.service;

import com.nightclub.nightclub_management.dto.UserRequestDto;
import com.nightclub.nightclub_management.model.UserEntity;
import com.nightclub.nightclub_management.enums.UserType;
import com.nightclub.nightclub_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Create a new user
    public UserEntity createUser(UserRequestDto userDto) {
        UserEntity user = UserEntity.builder()
                .id(UUID.randomUUID())
                .name(userDto.getName())
                .age(userDto.getAge())
                // ✅ Convert String to enum safely
                .userType(UserType.valueOf(userDto.getUserType().toUpperCase()))
                .username(userDto.getUsername())
                .password(userDto.getPassword()) // encode before saving in AuthService
                .build();

        return userRepository.save(user);
    }

    // Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Get one user by ID
    public UserEntity getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }
}
