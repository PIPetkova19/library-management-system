package org.example.librarymanagementsystem.services;

import org.example.librarymanagementsystem.models.Book;
import org.example.librarymanagementsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
