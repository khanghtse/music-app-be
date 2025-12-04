package com.example.music_app.dtos;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;
    private String password;
}
