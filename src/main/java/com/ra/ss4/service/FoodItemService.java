package com.ra.ss4.service;

import com.ra.ss4.model.entity.Category;
import com.ra.ss4.model.entity.FoodItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodItemService {
    Page<FoodItem> searchByName(String name, Pageable pageable);
    Page<FoodItem> filterByCategory(Category category, Pageable pageable);
    Page<FoodItem> searchByNameAndCategory(String name, Category category, Pageable pageable);
    Page<FoodItem> findAll(Pageable pageable);
    boolean save(FoodItem foodItem);
    boolean update(FoodItem foodItem);
    FoodItem findById(Integer id);
    boolean delete(Integer id);
}
