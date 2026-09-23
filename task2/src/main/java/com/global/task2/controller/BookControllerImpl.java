package com.global.task2.controller;

import com.global.task2.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.global.task2.entity.Book;

import java.util.List;
@RestController()
@RequestMapping("/books")
public class BookControllerImpl implements BookController{
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    public Book UpdateById(@PathVariable Integer id, @RequestBody @Valid Book book) {
        return bookService.UpdateById(id, book);
    }

    @DeleteMapping("/{id}")
    public Long deleteById(@PathVariable Integer book_id) {
        return bookService.deleteById(book_id);
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }






}
