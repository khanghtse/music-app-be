package com.example.music_app.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

//    private Boolean success;
//    private String message;
    private String token;
    private String email;
    private String role;

//    public static AuthResponse success(String token, String email, String role) {
//        return AuthResponse.builder()
//                .success(true)
//                .message("User logged in successfully")
//                .token(token)
//                .email(email)
//                .role(role)
//                .build();
//    }
//
//    public static AuthResponse error(String message) {
//        return AuthResponse.builder()
//                .success(false)
//                .message(message)
//                .build();
//    }
}
