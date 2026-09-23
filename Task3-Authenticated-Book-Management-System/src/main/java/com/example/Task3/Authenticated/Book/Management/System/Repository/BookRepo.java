package com.example.Task3.Authenticated.Book.Management.System.Repository;

import com.example.Task3.Authenticated.Book.Management.System.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
