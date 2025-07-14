package com.ra.ss4.controller;

import com.ra.ss4.model.entity.CategoryBook;
import com.ra.ss4.service.CategoryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryBookController {
    @Autowired
    private CategoryBookService categoryBookService;

    @GetMapping
    public String categories(@RequestParam(required = false) String categoryBookName,
                             Model model) {
        List<CategoryBook> categoryBooks = categoryBookService.getCategoryBooks(categoryBookName);
        model.addAttribute("categoryBooks", categoryBooks);
        model.addAttribute("categoryBookName", categoryBookName);
        return "category-list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("c", new CategoryBook());
        return "category-add";
    }

    @PostMapping("/save")
    public String save(CategoryBook cateBook){
        categoryBookService.insertCategoryBook(cateBook);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String formEditCategory(@PathVariable("id") String id, Model model){
        CategoryBook categoryBook = categoryBookService.getCategoryBookById(id);
        model.addAttribute("categoryBook", categoryBook);
        return "category-edit";
    }

    @PostMapping("/edit")
    public String edit(CategoryBook categoryBook){
        categoryBookService.updateCategoryBook(categoryBook);
        return "redirect:/category";
    }

    @GetMapping("/delete/{cateBookId}")
    public String delete(@PathVariable("cateBookId") String cateBookId){
        categoryBookService.deleteCategoryBookById(cateBookId);
        return "redirect:/category";
    }
}
