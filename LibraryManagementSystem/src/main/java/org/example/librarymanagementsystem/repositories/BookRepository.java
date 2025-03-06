package org.example.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.librarymanagementsystem.models.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

//BookRepository наследява всички стандартни CRUD операции
public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteBookByTitle(String title);

    // Търсене на книга по заглавие
    Optional<Book> findByTitle(String title);
   //update save
   @Modifying
   @Query("UPDATE Book b SET b.title = :title, b.author = :author WHERE b.title = :oldTitle")
   void updateBookByTitle(@Param("oldTitle") String oldTitle, @Param("title") String title, @Param("author") String author);

    //save(T entity) → Запазва (създава или обновява) книга (INSERT/UPDATE)
    //findById(ID id) → Намира книга по ID
    //findAll() → Връща списък с всички книги
    //count() → Връща броя на записите
    //deleteById(ID id) → Изтрива книга по ID
    //existsById(ID id) → Проверява дали съществува книга с дадено ID
    //findAll(Sort sort) → Връща всички книги със сортиране
    //findAll(Pageable pageable) → Връща странициран списък от книги
}
