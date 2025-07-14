package com.ra.ss4.service.imp;

import com.ra.ss4.model.entity.Book;
import com.ra.ss4.model.entity.CategoryBook;
import com.ra.ss4.repository.BookRepository;
import com.ra.ss4.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepo;

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public boolean addBook(Book book) {
        try {
            bookRepo.save(book);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBook(Book book) {
        bookRepo.findById(book.getBookId()).orElseThrow(()-> new NoSuchElementException("Khong ton tai book!"));
        try{
            bookRepo.save(book);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteBook(Integer bookId) {
        try {
            bookRepo.deleteById(bookId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepo.findById(bookId).orElseThrow(()-> new NoSuchElementException("Khong ton tai book!"));
    }

    @Override
    public List<Book> getBooksByBookNameAndAuthor(String bookName, String author) {
        return bookRepo.findBooksByBookNameContainsAndAuthorContains(bookName, author);
    }

    @Override
    public List<Book> getBooksByCategoryBook(String bookId) {
        CategoryBook cateBook = new CategoryBook();
        cateBook.setCateBookId(bookId);
        return bookRepo.findBooksByCategoryBook(cateBook);
    }
}
