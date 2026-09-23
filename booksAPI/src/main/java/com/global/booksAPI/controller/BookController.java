package com.global.booksAPI.controller;

import com.global.booksAPI.Service.BookService;
import com.global.booksAPI.entity.Book;
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
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book){
        return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Book>> findAll(){
        List<Book> books = (List<Book>) bookService.findAll();
        if(!books.isEmpty())
            return new ResponseEntity<>(books,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
        Book book = bookService.findById(id);
        if(book !=null)
            return new ResponseEntity<>(book,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody @Valid Book book){
        Book book_ = bookService.update(id,book);
        if(book_ !=null)
            return new ResponseEntity<>(book_,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer id){
        bookService.deleteById(id);
        return new ResponseEntity<>(1,HttpStatus.OK);
    }
}
