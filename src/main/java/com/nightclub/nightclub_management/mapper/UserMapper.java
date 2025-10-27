package com.nightclub.nightclub_management.mapper;

import com.nightclub.nightclub_management.dto.UserRequestDto;
import com.nightclub.nightclub_management.model.UserEntity;
import com.nightclub.nightclub_management.enums.UserType;


public class UserMapper {
    public static UserEntity fromDto(UserRequestDto dto, String hashedPassword) {
        return UserEntity.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .userType(UserType.valueOf(dto.getUserType()))
                .username(dto.getUsername())
                .password(hashedPassword)
                .build();
    }
}

