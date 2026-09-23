package com.example.Task3.Authenticated.Book.Management.System.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table

public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String fullname;

    @NotBlank
    String username;

    String email;

    @NotNull
    String password;

    private HashSet<String> roles;

    private boolean isEnabled;

    private boolean isCredentialsNonExpired;

    private boolean isAccountNonLocked;

    private boolean isAccountNonExpired;

    public MyUser(String username_, String password_){
        username = username_;
        password = password_;

        roles = new HashSet<>(Set.of("USER"));

        isEnabled = true;

        isCredentialsNonExpired = true;

        isAccountNonLocked = true;

        isAccountNonExpired = true;
    }


}
