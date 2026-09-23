package com.global.task2.repository;

import com.global.task2.entity.Author;
import com.global.task2.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

    /*@Modifying
    @Transactional
    @Query(name = "insert book ")
    public Book insertBookForAuthor(Integer author_id);*/
}
