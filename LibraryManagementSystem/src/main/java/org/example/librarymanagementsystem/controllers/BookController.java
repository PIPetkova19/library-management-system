package org.example.librarymanagementsystem.controllers;

import org.example.librarymanagementsystem.models.Status;
import org.example.librarymanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //Delete, но с postMapping, защото html form не поддържа delete
    @PostMapping("/delete")
    public String deleteBook(@RequestParam String title) { //Взема параметъра от шаблона
        bookService.deleteBookByTitle(title);
        return "redirect:/books"; // Рефрешва
    }

    //update
    @PostMapping("/update")
    public String updateBookByTitle(@RequestParam String oldTitle,
                                    @RequestParam String title,@RequestParam String author,
                                    @RequestParam String description,@RequestParam String status) {
        Status finalStatus = (status == null || status.isEmpty()) ? null : Status.valueOf(status.toUpperCase());//!

        bookService.updateBookByTitle(oldTitle, title, author,description, finalStatus);
        return "redirect:/books";
    }

    //add
    @PostMapping("/add")
    public String addBook(@RequestParam String titleAdd, @RequestParam String authorAdd,
                          @RequestParam String descriptionAdd,@RequestParam Status statusAdd) {
        bookService.addBook(titleAdd, authorAdd, descriptionAdd, statusAdd);
        return "redirect:/books";
    }

}
