package com.global.task2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.global.task2.entity.Book;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    @Query("SELECT book FROM Book book WHERE book.author.authorId = :author_id")
    List<Book> findByAuthorId(@Param("author_id") Integer author_id);

    @Query("SELECT book FROM Book book WHERE book.author.authorId = :author_id and book.id = :book_id")
    Book findByAuthorId(@Param("author_id") Integer author_id, @Param("book_id") Integer book_id);
    /*@Query("UPDATE book FROM Book book WHERE book.author.authorId = :author_id and book.id = :book_id") needs work
    List<Book> updateByAuthorId(@Param("author_id") Integer author_id, @Param("book_id") Integer book_id);*/

    @Transactional
    @Modifying
    @Query("DELETE FROM Book book WHERE book.author.authorId = :author_id and book.id = :book_id ")
    Integer deleteByAuthorIDAndBookId(@Param("author_id") Integer author_id, @Param("book_id") Integer book_id);

}
