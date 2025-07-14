package com.ra.ss4.service;

import com.ra.ss4.model.entity.CategoryBook;

import java.util.List;

public interface CategoryBookService {
    List<CategoryBook> getCategoryBooks(String categoryBookName);
    List<CategoryBook> findAll();
    boolean insertCategoryBook(CategoryBook categoryBook);
    boolean updateCategoryBook(CategoryBook categoryBook);
    boolean deleteCategoryBookById(String cateBookId);
    CategoryBook getCategoryBookById(String cateBookId);
    List<CategoryBook> getCategoryBooksByCategoryName(String categoryName);
}
