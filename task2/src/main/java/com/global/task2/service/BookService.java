package com.global.task2.service;

import java.net.http.HttpResponse;
import java.util.List;

import com.global.task2.entity.Book;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;


public interface BookService {

    Book insertBook(Book book);
    Book findById(Integer id);
    Book UpdateById(Integer book_id,Book book);
    Long deleteById(Integer book_id);
    List<Book> findAll();
    List<Book> findAuthorBooks(Integer author_id);
    Integer deleteByAuthorID(Integer book_id, Integer author_id);
    Book findByAuthorIdAndBookId(Integer book_id, Integer author_id);

    Book updateAuthorBook(Integer author_id, Integer book_id, Book book);
    public Book insertBookForAuthor(Book book, Integer author_id);
}
