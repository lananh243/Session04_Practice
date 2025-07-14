package com.ra.ss4.controller;

import com.ra.ss4.model.entity.Book;
import com.ra.ss4.service.BookService;
import com.ra.ss4.service.CategoryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryBookService categoryBookService;

    @GetMapping
    public String listBook(Model model) {
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList", bookList);
        return "list-book";
    }

    @GetMapping("/category")
    public String books(@RequestParam("cateBookId") String cateBookId, Model model) {
        List<Book> books = bookService.getBooksByCategoryBook(cateBookId);
        model.addAttribute("books", books);
        return "list-book-byId";
    }


    @GetMapping("/add")
    public String formAddBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categoryBook", categoryBookService.getCategoryBooks());
        return "book-add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        String cateId = book.getCategoryBook().getCateBookId();
        book.setCategoryBook(categoryBookService.getCategoryBookById(cateId));
        bookService.addBook(book);
        return "redirect:/book";
    }

    @GetMapping("/edit/{id}")
    public String formEditBook(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categoryBook", categoryBookService.getCategoryBooks());
        return "book-edit";
    }

    @PostMapping("/edit")
    public String editBook(Book book) {
        String cateId = book.getCategoryBook().getCateBookId();
        book.setCategoryBook(categoryBookService.getCategoryBookById(cateId));
        bookService.updateBook(book);
        return "redirect:/book";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }
}
