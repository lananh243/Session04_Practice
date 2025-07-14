package com.ra.ss4.service;

import com.ra.ss4.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
}
