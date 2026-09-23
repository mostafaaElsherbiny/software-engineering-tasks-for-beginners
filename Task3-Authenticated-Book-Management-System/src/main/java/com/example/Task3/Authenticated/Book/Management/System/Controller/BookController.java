package com.example.Task3.Authenticated.Book.Management.System.Controller;


import com.example.Task3.Authenticated.Book.Management.System.DTOs.BookDto;
import com.example.Task3.Authenticated.Book.Management.System.Entity.Book;
import com.example.Task3.Authenticated.Book.Management.System.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")

public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping()
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookDto book){
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long bookId, @Valid @RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBookById(bookId,book), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<Book>> findAllBooks(){
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> findBookById(@PathVariable Long bookId){
        return new ResponseEntity<>(bookService.findBookById(bookId), HttpStatus.OK);
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Long> deleteById(@PathVariable Long bookId){
        bookService.deleteBookById(bookId);
        return new ResponseEntity<>(1L, HttpStatus.OK);
    }


}
