package com.app.Library.controller;

import com.app.Library.model.Book;
import com.app.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

//  Get all books
    @GetMapping("/user/{userId}/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
}

//  Borrowing Book
    @PostMapping("/user/{userId}/books")
    public ResponseEntity<String> borrowBook(@PathVariable int userId, @RequestBody int bookId) {
    String response = bookService.borrowBook(userId, bookId);
    return new ResponseEntity<>(response, HttpStatus.OK);
}

}
