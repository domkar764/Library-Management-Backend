package com.app.Library.controller;

import com.app.Library.model.Author;
import com.app.Library.model.Book;
import com.app.Library.model.Restock;
import com.app.Library.service.AuthorService;
import com.app.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

//  Adding Author
    @PostMapping("/add/author")
    public void addAuthor(@RequestBody Author author) {
        authorService.save(author);
    }

//  Adding Books
    @PostMapping("/add/book")
    public void addAuthor(@RequestBody Book book) {
        bookService.save(book);
    }

//  Update stock
    @PutMapping("/update/stock")
    public void updateStock(@RequestBody Restock restock) {
        int bookId = restock.getBookId();
        int stock = restock.getStock();
        bookService.updateStock(bookId, stock);
    }



}
