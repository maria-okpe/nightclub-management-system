package com.nightclub.nightclub_management.service;

import com.nightclub.nightclub_management.dto.AuthResponseDto;
import com.nightclub.nightclub_management.dto.UserRequestDto;
import com.nightclub.nightclub_management.model.UserEntity;
import com.nightclub.nightclub_management.mapper.UserMapper;
import com.nightclub.nightclub_management.repository.UserRepository;
import com.nightclub.nightclub_management.security.JwtUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;

    public AuthService(UserRepository repo,
                       PasswordEncoder encoder,
                       JwtUtil jwtUtil,
                       AuthenticationManager authManager) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
    }

    public AuthResponseDto register(UserRequestDto dto) {
        if (repo.existsByUsername(dto.getUsername())) {
            return AuthResponseDto.builder()
                    .message("Username already taken")
                    .build();
        }

        String hashed = encoder.encode(dto.getPassword());
        UserEntity u = UserMapper.fromDto(dto, hashed);
        repo.save(u);

        String token = jwtUtil.generateToken(u.getUsername(), u.getUserType().name());
        return AuthResponseDto.builder()
                .message("Registration successful")
                .token(token)
                .username(u.getUsername())
                .userType(u.getUserType().name())
                .build();
    }

    public AuthResponseDto login(String username, String password) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (AuthenticationException ex) {
            return AuthResponseDto.builder()
                    .message("Invalid username or password")
                    .build();
        }

        UserEntity u = repo.findByUsername(username).orElseThrow();
        String token = jwtUtil.generateToken(username, u.getUserType().name());
        return AuthResponseDto.builder()
                .message("Login successful")
                .token(token)
                .username(username)
                .userType(u.getUserType().name())
                .build();
    }
}

