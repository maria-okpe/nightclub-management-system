
/*package com.nightclub.nightclub_management.controller;

import com.nightclub.nightclub_management.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @GetMapping("/common")
    public ResponseEntity<ApiResponse<String>> commonRoom() {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("Access granted to common room")
                .data("Welcome to the Common Room — any authenticated user may enter")
                .build());
    }

    @PreAuthorize("hasRole('BUSINESS')")
    @GetMapping("/business")
    public ResponseEntity<ApiResponse<String>> businessRoom() {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("Access granted to business room")
                .data("Welcome to the Business Room — only BUSINESS users may enter")
                .build());
    }

    @PreAuthorize("hasRole('VIP')")
    @GetMapping("/exclusive")
    public ResponseEntity<ApiResponse<String>> exclusiveRoom() {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("Access granted to exclusive room")
                .data("Welcome to the Exclusive Room — VIP users only")
                .build());
    }
} */

package com.nightclub.nightclub_management.controller;

import com.nightclub.nightclub_management.dto.ApiResponse;
import com.nightclub.nightclub_management.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Anyone with a valid token can enter
    @GetMapping("/common")
    public ResponseEntity<ApiResponse<String>> commonRoom() {
        String message = roomService.enterCommonRoom();
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("Access granted to common room")
                .data(message)
                .build());
    }

    // Only BUSINESS users
    @PreAuthorize("hasRole('BUSINESS')")
    @GetMapping("/business")
    public ResponseEntity<ApiResponse<String>> businessRoom() {
        String message = roomService.enterBusinessRoom();
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("Access granted to business room")
                .data(message)
                .build());
    }

    // Only VIP users
    @PreAuthorize("hasRole('VIP')")
    @GetMapping("/exclusive")
    public ResponseEntity<ApiResponse<String>> exclusiveRoom() {
        String message = roomService.enterExclusiveRoom();
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("Access granted to exclusive room")
                .data(message)
                .build());
    }
}

