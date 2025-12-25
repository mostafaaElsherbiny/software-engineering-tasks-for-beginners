package com.example.Task3.Authenticated.Book.Management.System.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String title;

    String author;

    Date publishedDate;

}
