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

    public Book(String s, String s1) {
title=s;
author=s1;
    }

    public Book() {

    }


    public Long getId() {return id;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}

    public void setId(Long id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
}
