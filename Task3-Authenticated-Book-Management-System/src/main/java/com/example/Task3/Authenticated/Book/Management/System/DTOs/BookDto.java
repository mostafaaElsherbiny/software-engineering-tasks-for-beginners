package com.example.Task3.Authenticated.Book.Management.System.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookDto {


    @NotBlank
    private String author;

    @NotBlank
    private String title;

    Date publishedDate;
}
