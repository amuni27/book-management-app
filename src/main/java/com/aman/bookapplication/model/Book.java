package com.aman.bookapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String isbn;
    String title;
    LocalDate publicationDate;
    BigDecimal price;

    public Book(String isbn, String title, LocalDate publicationDate, BigDecimal price) {
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.price = price;
    }
}
