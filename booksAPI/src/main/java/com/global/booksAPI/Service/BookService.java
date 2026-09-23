package com.global.booksAPI.Service;

import com.global.booksAPI.entity.Book;
import com.global.booksAPI.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    public Book create(Book book){
        bookRepo.save(book);
        return book;
    }
    public Book update(Integer id,Book book){
        book.setId(id);
        bookRepo.save(book);
        return book;
    }

    public Book findById(Integer id){
        return bookRepo.findById(id).get();
    }
    public Iterable<Book> findAll(){
        return  bookRepo.findAll();

    }
    public void deleteById(Integer id){
        bookRepo.deleteById(id);
    }




}
