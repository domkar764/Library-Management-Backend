package com.app.Library.service;

import com.app.Library.model.Book;

import java.util.List;

public interface BookService {
    void save(Book book);

    String borrowBook(int userId, int bookId);

    List<Book> getAllBooks();
}
