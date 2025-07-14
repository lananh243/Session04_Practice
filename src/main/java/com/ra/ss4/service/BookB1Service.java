package com.ra.ss4.service;

import com.ra.ss4.model.entity.BookB1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookB1Service {
    Page<BookB1> findAll(String title, Pageable pageable);
    boolean save(BookB1 book);
    BookB1 findByBookId(String bookId);
    boolean update(BookB1 book);
    boolean delete(String bookId);
}
