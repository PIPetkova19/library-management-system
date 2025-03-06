package org.example.librarymanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоматично генериране на ID
    private Long id;
    private String title;
    private String author;
    private String description;
    private Status status;

    //За инициализиция на обекти
    public Book(String title, String author, String description, Status status) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.status = status;
    }

    //Ако няма конструктор без параметри, JPA няма как да създаде празен обект и после да му зададе стойности.
    public Book() {}

    //getters
    public Long getId() {return id;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public String getDescription() {return description;}
    public Status getStatus() {return status;}

    //setters
    public void setId(Long id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setDescription(String description) {this.description = description;}
    public void setStatus(Status status) {this.status = status;}
}
