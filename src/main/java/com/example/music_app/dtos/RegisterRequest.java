package com.example.music_app.dtos;

import lombok.Data;

@Data
public class RegisterRequest {

    private String email;
    private String password;
}
