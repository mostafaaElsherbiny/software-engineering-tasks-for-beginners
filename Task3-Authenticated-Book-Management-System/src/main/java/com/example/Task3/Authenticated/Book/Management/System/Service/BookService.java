package com.example.Task3.Authenticated.Book.Management.System.Service;


import com.example.Task3.Authenticated.Book.Management.System.Entity.Book;
import com.example.Task3.Authenticated.Book.Management.System.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book createBook(Book book){
        return bookRepo.save(book);
    }
    public Book updateBookById(Long bookId, Book book){
        if(bookRepo.existsById(bookId)){
            Book book1 = bookRepo.findById(bookId).get();
            if(book.getAuthor()!=null)
                book1.setAuthor(book.getAuthor());
            if(book.getTitle()!=null)
                book1.setTitle(book.getTitle());
            if(book.getPublishedDate()!=null)
                book1.setPublishedDate(book.getPublishedDate());
            return bookRepo.save(book1);
        }
        else return null;
    }
    public Book findBookById(Long bookId){
        return bookRepo.findById(bookId).get();
    }
    public List<Book> findAll(){
        return bookRepo.findAll();
    }
    public void deleteBookById(Long bookId){
        bookRepo.deleteById(bookId);
    }


}
