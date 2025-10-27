package com.nightclub.nightclub_management.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseDto {
    private String message;
    private String token;
    private String username;
    private String userType;
}
