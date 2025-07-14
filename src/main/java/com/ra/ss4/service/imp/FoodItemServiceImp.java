package com.ra.ss4.service.imp;

import com.ra.ss4.model.entity.Category;
import com.ra.ss4.model.entity.FoodItem;
import com.ra.ss4.repository.FoodItemRepository;
import com.ra.ss4.service.FoodItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodItemServiceImp implements FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepo;

    @Override
    public Page<FoodItem> searchByName(String name, Pageable pageable) {
        return foodItemRepo.findByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Page<FoodItem> filterByCategory(Category category, Pageable pageable) {
        return foodItemRepo.findByCategory(category, pageable);
    }

    @Override
    public Page<FoodItem> searchByNameAndCategory(String name, Category category, Pageable pageable) {
        return foodItemRepo.findByNameContainingIgnoreCaseAndCategory(name, category, pageable);
    }

    @Override
    public Page<FoodItem> findAll(Pageable pageable) {
        return foodItemRepo.findAll(pageable);
    }

    @Override
    public boolean save(FoodItem foodItem) {
        try {
            foodItemRepo.save(foodItem);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(FoodItem foodItem) {
        try {
            foodItemRepo.save(foodItem);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public FoodItem findById(Integer id) {
        return foodItemRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Ko ton tai FoodItem"));
    }

    @Override
    public boolean delete(Integer id) {
        try {
            foodItemRepo.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
