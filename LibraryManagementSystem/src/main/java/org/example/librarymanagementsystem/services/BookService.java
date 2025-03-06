package org.example.librarymanagementsystem.services;

import org.example.librarymanagementsystem.models.Book;
import org.example.librarymanagementsystem.models.Status;
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
    public void updateBookByTitle(String oldTitle, String title, String author, String description, Status status) {
        Book book = bookRepository.findByTitle(oldTitle)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with title: " + oldTitle));
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        bookRepository.save(book); // Запази промените в базата данни
    }

    //add
    @Transactional
    public void addBook(String titleAdd, String authorAdd, String descriptionAdd, Status statusAdd) {
        Book book=new Book();
        book.setTitle(titleAdd);
        book.setAuthor(authorAdd);
        book.setDescription(descriptionAdd);
        book.setStatus(statusAdd);
        bookRepository.save(book);
    }

}
