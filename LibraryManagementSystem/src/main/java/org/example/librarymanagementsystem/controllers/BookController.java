package org.example.librarymanagementsystem.controllers;

import org.example.librarymanagementsystem.models.Book;
import org.example.librarymanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";  // Подаваме "books" като атрибут на шаблона
    }
}
