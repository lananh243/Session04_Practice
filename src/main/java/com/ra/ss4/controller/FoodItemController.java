package com.ra.ss4.controller;

import com.ra.ss4.model.entity.Category;
import com.ra.ss4.model.entity.FoodItem;
import com.ra.ss4.repository.CategoryRepository;
import com.ra.ss4.service.CategoryService;
import com.ra.ss4.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/food-items")
public class FoodItemController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public String listFoodItems(@RequestParam(required = false) String name,
                                @RequestParam(required = false) Integer categoryId,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size,
                                Model model){
        Pageable pageable = PageRequest.of(page, size);
        Page<FoodItem> foodItems;

        if (name != null && !name.isEmpty() && categoryId != null) {
            Category category = categoryService.findById(categoryId);
            foodItems = foodItemService.searchByNameAndCategory(name, category, pageable);
        } else if (name != null && !name.isEmpty()) {
            foodItems = foodItemService.searchByName(name, pageable);
        } else if (categoryId != null) {
            Category category = categoryService.findById(categoryId);
            foodItems = foodItemService.filterByCategory(category, pageable);
        } else {
            foodItems = foodItemService.findAll(pageable);
        }

        model.addAttribute("foodItems", foodItems);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("selectedName", name);
        model.addAttribute("selectedCategoryId", categoryId);
        model.addAttribute("currentPage", foodItems.getNumber());
        model.addAttribute("totalPages", foodItems.getTotalPages());
        return "B3/food-items";
    }

    @GetMapping("/add")
    public String formAddFoodItem(Model model){
        FoodItem foodItem = new FoodItem();
        model.addAttribute("foodItem", foodItem);
        model.addAttribute("categories", categoryService.findAll());
        return "B3/food-item-add";
    }

    @PostMapping("/add")
    public String addFoodItem(FoodItem foodItem){
        foodItemService.save(foodItem);
        return "redirect:/food-items";
    }
}
