package com.global.task2.controller;


import com.global.task2.entity.Author;
import com.global.task2.entity.Book;
import com.global.task2.service.AuthorService;
import com.global.task2.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")

public class AuthorControllerImpl implements AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private  BookService bookService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody @Valid Author author){
        Author author_ = authorService.createAuthor(author);
        return new ResponseEntity<>(author_, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthorById(@PathVariable Integer id, @RequestBody @Valid Author author){
        Author author_ = authorService.findById(id);
        author_.setName(author.getName());
        author_.setBirthDate((author.getBirthDate()));
        return new ResponseEntity<>(authorService.updateAuthor(author_), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Author>> findAllAuthor(){
        return new ResponseEntity<>(authorService.findAllAuthors(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Integer id){
        return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAuthor(@PathVariable Integer id){
        authorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
   @GetMapping("/{author_id}/books")
    public ResponseEntity<List<Book>> findAuthorBooks(@PathVariable Integer author_id){
        return new ResponseEntity<>(bookService.findAuthorBooks(author_id), HttpStatus.OK);

    }
    @PostMapping("/{author_id}/books")
    public ResponseEntity<Book> createBookForAuthor(@PathVariable Integer author_id, @RequestBody @Valid Book book){
        return new ResponseEntity<>(bookService.insertBookForAuthor(book,author_id), HttpStatus.OK);
    }
    @GetMapping("/{author_id}/books/{book_id}")
    public ResponseEntity<Book> getAuthorBook(@PathVariable Integer author_id, @PathVariable Integer book_id){
        return new ResponseEntity<>(bookService.findByAuthorIdAndBookId(book_id, author_id), HttpStatus.OK);
    }
    @PutMapping("/{author_id}/books/{book_id}")
    public ResponseEntity<Book> updateAuthorBook(@PathVariable Integer author_id,@PathVariable Integer book_id,
                                                       @RequestBody @Valid Book book){
        return new ResponseEntity<>(bookService.updateAuthorBook(author_id, book_id, book), HttpStatus.OK);
    }


    @DeleteMapping("{author_id}/books/{book_id}")
    public ResponseEntity<Integer> deleteBookForAuthor(@PathVariable Integer author_id, @PathVariable Integer book_id){
        return new ResponseEntity<>(bookService.deleteByAuthorID(book_id, author_id), HttpStatus.OK);
    }




}
