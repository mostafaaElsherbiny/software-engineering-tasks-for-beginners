package com.global.task2.service;

import com.global.task2.entity.Author;
import com.global.task2.entity.Book;

import java.net.http.HttpResponse;
import java.util.List;

public interface AuthorService {
    public boolean authorExists(Integer author_id);
    public Author createAuthor(Author author);
    public Author updateAuthor(Author author);
    public List<Author> findAllAuthors();
    public Author findById(Integer id);
    public void deleteById(Integer id);

}
