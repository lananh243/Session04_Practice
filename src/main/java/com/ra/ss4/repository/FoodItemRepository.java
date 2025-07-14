package com.ra.ss4.repository;

import com.ra.ss4.model.entity.Category;
import com.ra.ss4.model.entity.FoodItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem,Integer> {
    Page<FoodItem> findByNameContainingIgnoreCaseAndCategory(String name, Category category, Pageable pageable);
    Page<FoodItem> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<FoodItem> findByCategory(Category category, Pageable pageable);

}
