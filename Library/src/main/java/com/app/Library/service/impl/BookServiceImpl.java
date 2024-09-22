package com.app.Library.service.impl;

import com.app.Library.model.Book;
import com.app.Library.repo.BookRepo;
import com.app.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;


    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public String borrowBook(int userId, int bookId) {
        Optional<Book> bookOpt = bookRepo.findById(bookId);

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.getStock() > 0) {
                book.setStock(book.getStock() - 1);
                bookRepo.save(book);
                return "Book borrowed successfully!";
            } else {
                return "Book is out of stock!";
            }
        } else {
            return "Book not found!";
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public String updateStock(int bookId, int stock) {
        Optional<Book> bookOptional = bookRepo.findById(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setStock(stock+book.getStock());
            bookRepo.save(book); // Save the updated book
            return "Stock updated successfully for book: " + book.getTitle();
        }
        return "Book not found with ID: " + bookId;
    }

}
