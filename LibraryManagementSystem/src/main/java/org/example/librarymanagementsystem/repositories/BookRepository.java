package org.example.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.librarymanagementsystem.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
