package com.global.task2.service;

import com.global.task2.entity.Author;
import com.global.task2.entity.Book;
import com.global.task2.repository.AuthorRepo;
import com.global.task2.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepo authorRepo;




    @Override
    public boolean authorExists(Integer author_id) {
        return authorRepo.existsById(author_id);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Author updateAuthor(Author author){
        if(authorRepo.exists(Example.of(author))) {
            Author author1  = authorRepo.findById(author.getAuthorId()).get();
            if(author.getName() !=null)
                author1.setName(author.getName());
            if(author.getBirthDate() !=null)
                author1.setBirthDate(author.getBirthDate());
            author1.setBooks(author.getBooks());
            return authorRepo.save(author1);
        }
        else return null;
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author findById(Integer id) {
        return authorRepo.findById(id).get();

    }

    @Override
    public void deleteById(Integer id) {
         authorRepo.deleteById(id);
    }

    /*@Override
    public Long deleteById(Integer id) {
        return 0L;
    }*/




}
