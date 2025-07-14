package com.ra.ss4.service.imp;

import com.ra.ss4.model.entity.BookB1;
import com.ra.ss4.repository.BookB1Repository;
import com.ra.ss4.service.BookB1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class Book1ServiceImp implements BookB1Service {
    @Autowired
    private BookB1Repository bookB1Repo;

    @Override
    public Page<BookB1> findAll(String title, Pageable pageable) {
        if (title == null || title.isEmpty()) {
            return bookB1Repo.findAll(pageable);
        }
        return bookB1Repo.findByTitleContainingIgnoreCase(title, pageable);
    }

    @Override
    public boolean save(BookB1 book) {
        try {
            bookB1Repo.save(book);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public BookB1 findByBookId(String bookId) {
        return bookB1Repo.findById(bookId).orElseThrow(()-> new NoSuchElementException("Khong ton tai book!"));
    }

    @Override
    public boolean update(BookB1 book) {
        try {
            bookB1Repo.save(book);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String bookId) {
        try {
            bookB1Repo.deleteById(bookId);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
