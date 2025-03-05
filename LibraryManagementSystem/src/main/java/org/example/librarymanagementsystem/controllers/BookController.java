package org.example.librarymanagementsystem.controllers;

import org.example.librarymanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Контролер за обработка на заявки
@Controller
public class BookController {
//enable automatic dependency injection
    @Autowired
    private BookService bookService;
    // Обработва get заявка на "/books"
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        // Добавя книгите в модела
        model.addAttribute("books", bookService.getAllBooks());
        // Връща шаблона "index"
        return "index";
    }
}
