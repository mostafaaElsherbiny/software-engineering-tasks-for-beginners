package com.example.Task3.Authenticated.Book.Management.System.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;

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

    HashSet<String> roles;

    public MyUser(String username_, String password_){
        username = username_;
        password = password_;
    }


}
