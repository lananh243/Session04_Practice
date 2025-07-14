package com.ra.ss4.repository;

import com.ra.ss4.model.entity.CategoryBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryBookRepository extends JpaRepository<CategoryBook,String> {
    List<CategoryBook> findCategoryBooksByCateBookNameContains(String categoryBookName);
}
