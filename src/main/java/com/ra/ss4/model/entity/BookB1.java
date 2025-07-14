package com.ra.ss4.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookB1 {
    @Id
    @Column(name = "book_id")
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private Integer year;
}
