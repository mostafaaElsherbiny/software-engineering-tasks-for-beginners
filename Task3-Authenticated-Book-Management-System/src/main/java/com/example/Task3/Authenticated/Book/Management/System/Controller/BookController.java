package com.example.Task3.Authenticated.Book.Management.System.Controller;


import com.example.Task3.Authenticated.Book.Management.System.Entity.Book;
import com.example.Task3.Authenticated.Book.Management.System.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")

public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping()
    public ResponseEntity<Book> createBook(@Valid Book book){
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<Book> updateBookById(Long Id, @Valid Book book){
        return new ResponseEntity<>(bookService.updateBookById(Id,book), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Book>> findAll(){
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> findById(Long Id){
        return new ResponseEntity<>(bookService.findBookById(Id), HttpStatus.FOUND);
    }
    @DeleteMapping()
    public ResponseEntity<Long> deleteById(Long Id){
        bookService.deleteBookById(Id);
        return new ResponseEntity<>(1L, HttpStatus.OK);
    }


}
