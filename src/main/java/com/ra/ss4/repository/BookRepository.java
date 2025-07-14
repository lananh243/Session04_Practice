package com.ra.ss4.repository;

import com.ra.ss4.model.entity.Book;
import com.ra.ss4.model.entity.CategoryBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findBooksByBookNameContainsAndAuthorContains(String bookName, String author);

    List<Book> findBooksByCategoryBook(CategoryBook categoryBook);
}
