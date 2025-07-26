package com.global.task2.service;

import com.global.task2.entity.Author;
import com.global.task2.entity.Book;
import com.global.task2.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorService authorService;



    @Override
    public List<Book> findAuthorBooks(Integer author_id) {
        return bookRepo.findByAuthorId(author_id);
    }

    @Override
    public Integer deleteByAuthorID(Integer book_id, Integer author_id) {
        return bookRepo.deleteByAuthorIDAndBookId(author_id, book_id);
    }

    @Override
    public Book findByAuthorIdAndBookId(Integer book_id, Integer author_id) {
        return bookRepo.findByAuthorId(author_id, book_id);
    }

    @Override
    public Book updateAuthorBook(Integer author_id, Integer book_id, Book book) {
        Book book_ = bookRepo.getReferenceById(book_id);
        if(!bookRepo.existsById(book_id )|| !authorService.authorExists(author_id) )
            return null;
        if(book.getTitle()!=null)
            book_.setTitle(book.getTitle());
        if(book.getPublishedDate()!=null)
            book_.setPublishedDate(book.getPublishedDate());
        bookRepo.save(book_);
        return book_;
    }

    @Override
    public Book insertBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public Book UpdateById(Integer book_id, Book book) {
        Book b = findById(book_id);
        b.setAuthor((book.getAuthor()));
        b.setTitle(book.getTitle());
        b.setPublishedDate(book.getPublishedDate());
        bookRepo.save(b);
        return b;
    }

    @Override
    public Long deleteById(Integer book_id) {
         bookRepo.deleteById(book_id);
         return 0L;

    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }
    @Override
    public Book insertBookForAuthor(Book book, Integer author_id){
        if(!authorService.authorExists(author_id))
            return null;
        Author author = authorService.findById(author_id);
        book.setAuthor(author);
        return bookRepo.save(book);

    }

}
