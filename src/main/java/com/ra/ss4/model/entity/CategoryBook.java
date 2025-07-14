package com.ra.ss4.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "category_book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBook {
    @Id
    @Column(name = "cate_book_id", length = 20)
    private String cateBookId;
    @Column(name = "cate_book_name", length = 100, unique = true, nullable = false)
    private String cateBookName;

    @OneToMany(mappedBy = "categoryBook")
    private List<Book> books;
}
