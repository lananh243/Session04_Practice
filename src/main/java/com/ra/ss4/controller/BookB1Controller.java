package com.ra.ss4.controller;

import com.ra.ss4.model.entity.BookB1;
import com.ra.ss4.service.BookB1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookB1Controller {
    @Autowired
    private BookB1Service bookB1Service;

    @GetMapping
    public String books(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "5") int size,
                        @RequestParam(required = false) String title,
                        Model model) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("bookId").descending());
        Page<BookB1> books = bookB1Service.findAll(title, pageable);
        model.addAttribute("books", books);
        model.addAttribute("currentPage", books.getNumber());
        model.addAttribute("totalPages", books.getTotalPages());
        model.addAttribute("title", title);
        return "B1/books";
    }

    @GetMapping("/add")
    public String formAddBook(Model model) {
        model.addAttribute("book", new BookB1());
        return "B1/bookB1-add";
    }

    @PostMapping("/add")
    public String addBook(BookB1 bookB1) {
        bookB1Service.save(bookB1);
        return "redirect:/books";
    }

    @GetMapping("edit/{bookId}")
    public String formEditBook(@PathVariable String bookId, Model model) {
        BookB1 book = bookB1Service.findByBookId(bookId);
        model.addAttribute("book", book);
        return "B1/bookB1-edit";
    }

    @PostMapping("/edit")
    public String editBook(BookB1 bookB1) {
        bookB1Service.update(bookB1);
        return "redirect:/books";
    }

    @GetMapping("delete/{bookId}")
    public String deleteBook(@PathVariable String bookId) {
        bookB1Service.delete(bookId);
        return "redirect:/books";
    }
}
