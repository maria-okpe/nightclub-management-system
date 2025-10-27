package com.nightclub.nightclub_management.util;

import com.nightclub.nightclub_management.model.UserEntity;
import com.nightclub.nightclub_management.enums.UserType;
import com.nightclub.nightclub_management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public DataSeeder(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() == 0) {
            repo.save(UserEntity.builder()
                    .name("Alice VIP")
                    .age(30)
                    .userType(UserType.VIP)
                    .username("alice")
                    .password(encoder.encode("alicepwd"))
                    .build());

            repo.save(UserEntity.builder()
                    .name("Bob Business")
                    .age(35)
                    .userType(UserType.BUSINESS)
                    .username("bob")
                    .password(encoder.encode("bobpwd"))
                    .build());

            repo.save(UserEntity.builder()
                    .name("Charlie User")
                    .age(22)
                    .userType(UserType.USER)
                    .username("charlie")
                    .password(encoder.encode("charliepwd"))
                    .build());
        }
    }
}

