package com.nightclub.nightclub_management.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import com.nightclub.nightclub_management.enums.UserType;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Column(nullable = false, unique = true)
    private String username; // for login

    @Column(nullable = false)
    private String password; // hashed
}
