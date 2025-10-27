
/*package com.nightclub.nightclub_management.controller;

import com.nightclub.nightclub_management.dto.*;
import com.nightclub.nightclub_management.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponseDto>> register(@Valid @RequestBody UserRequestDto dto) {
        var resp = service.register(dto);
        return ResponseEntity.status(resp.getToken() == null ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED)
                .body(ApiResponse.<AuthResponseDto>builder()
                        .message(resp.getMessage())
                        .data(resp)
                        .build());
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponseDto>> login(@RequestBody LoginRequest login) {
        var resp = service.login(login.getUsername(), login.getPassword());
        return ResponseEntity.status(resp.getToken() == null ? HttpStatus.UNAUTHORIZED : HttpStatus.OK)
                .body(ApiResponse.<AuthResponseDto>builder()
                        .message(resp.getMessage())
                        .data(resp)
                        .build());
    }

    // inner simple DTO for login
    public static record LoginRequest(String username, String password) {
        public String getUsername() {
            return "";
        }

        public String getPassword() {
            return "";
        }
    }
}*/


package com.nightclub.nightclub_management.controller;

import com.nightclub.nightclub_management.dto.*;
import com.nightclub.nightclub_management.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponseDto>> register(
            @Valid @RequestBody UserRequestDto dto
    ) {
        var resp = service.register(dto);
        return ResponseEntity.status(resp.getToken() == null ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED)
                .body(ApiResponse.<AuthResponseDto>builder()
                        .message(resp.getMessage())
                        .data(resp)
                        .build());
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponseDto>> login(
            @Valid @RequestBody LoginRequest login
    ) {
        var resp = service.login(login.username(), login.password());
        return ResponseEntity.status(resp.getToken() == null ? HttpStatus.UNAUTHORIZED : HttpStatus.OK)
                .body(ApiResponse.<AuthResponseDto>builder()
                        .message(resp.getMessage())
                        .data(resp)
                        .build());
    }

    // Login DTO (record)
    public static record LoginRequest(String username, String password) { }
}
