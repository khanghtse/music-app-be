package com.example.music_app.services;

import com.example.music_app.documents.User;
import com.example.music_app.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataInitializationService implements CommandLineRunner {

    private final IUserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        createDefaultAdminUser();
    }

    private void createDefaultAdminUser() {
        // check if admin already exist
        if (!userRepository.existsByEmail("khanghoang090703@gmail.com")) {
            User adminUser = User.builder()
                    .email("khanghoang090703@gmail.com")
                    .role(User.Role.ADMIN)
                    .build();

            userRepository.save(adminUser);
            log.info("Admin user created successfully");
        } else {
            log.info("Admin user already exists");
        }
    }
}
