package com.nightclub.nightclub_management.dto;

import com.nightclub.nightclub_management.validation.AgeAbove18;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank
    private String name;

    @AgeAbove18
    private Integer age;

    @NotNull
    private String userType; // accept strings "USER", "BUSINESS", "VIP"

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}

