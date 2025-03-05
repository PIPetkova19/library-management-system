package org.example.librarymanagementsystem.services;

import org.example.librarymanagementsystem.models.Book;
import org.example.librarymanagementsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Указва, че това е Service клас, управляващ бизнес логика
@Service
public class BookService {
    // Автоматично инжектиране на зависимостта към BookRepository
    @Autowired
    private BookRepository bookRepository;
// Извиква метод от репозиторието за получаване на всички книги

    //read
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
