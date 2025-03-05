package org.example.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.librarymanagementsystem.models.Book;

//BookRepository наследява всички стандартни CRUD операции
public interface BookRepository extends JpaRepository<Book, Long> {
    //save(T entity) → Запазва (създава или обновява) книга (INSERT/UPDATE)
    //findById(ID id) → Намира книга по ID
    //findAll() → Връща списък с всички книги
    //count() → Връща броя на записите
    //deleteById(ID id) → Изтрива книга по ID
    //existsById(ID id) → Проверява дали съществува книга с дадено ID
    //findAll(Sort sort) → Връща всички книги със сортиране
    //findAll(Pageable pageable) → Връща странициран списък от книги
}
