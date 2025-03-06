package org.example.librarymanagementsystem.services;

import org.example.librarymanagementsystem.models.Book;
import org.example.librarymanagementsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //delete
    @Transactional //string boot jpa го изисква, при промени в БД
    public void deleteBookByTitle(String title){
        bookRepository.deleteBookByTitle(title);
    }

    //update
    @Transactional
    public void updateBookByTitle(String oldTitle, String title, String author) {
        Book book = bookRepository.findByTitle(oldTitle)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with title: " + oldTitle));
        book.setTitle(title); // Обнови заглавието
        book.setAuthor(author); // Обнови автора

        bookRepository.save(book); // Запази промените в базата данни
    }

    //add
    @Transactional
    public void addBook(String titleAdd, String authorAdd) {
        Book book=new Book();
        book.setTitle(titleAdd);
        book.setAuthor(authorAdd);
        bookRepository.save(book);
    }

}
