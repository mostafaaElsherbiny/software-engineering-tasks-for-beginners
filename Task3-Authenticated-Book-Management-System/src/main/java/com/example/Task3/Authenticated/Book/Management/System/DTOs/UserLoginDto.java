package com.example.Task3.Authenticated.Book.Management.System.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserLoginDto {


    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
