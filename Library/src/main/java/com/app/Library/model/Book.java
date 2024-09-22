package com.app.Library.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "stock")
    private int stock;
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

}
