package org.example.librarymanagementsystem;

import org.example.librarymanagementsystem.models.Book;
import org.example.librarymanagementsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component  // Това ще гарантира, че Spring ще открие класа и ще го изпълни автоматично
public class DataInitializer implements CommandLineRunner {

    // Внедряване на зависимостта BookRepository
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Добавяне на книги в базата данни
        if (bookRepository.count() == 0) {  // Проверка дали има книги в базата
            bookRepository.save(new Book("The Catcher in the Rye", "J.D. Salinger"));
            bookRepository.save(new Book("To Kill a Mockingbird", "Harper Lee"));
            bookRepository.save(new Book("1986", "George Orwell"));
            bookRepository.save(new Book("1985", "George Orwell"));
            bookRepository.save(new Book("1984", "George Orwell"));

            System.out.println("Sample books added to the database.");
        }
    }
}
