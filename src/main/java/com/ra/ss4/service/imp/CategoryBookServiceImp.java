package com.ra.ss4.service.imp;

import com.ra.ss4.model.entity.CategoryBook;
import com.ra.ss4.repository.CategoryBookRepository;
import com.ra.ss4.service.CategoryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryBookServiceImp implements CategoryBookService {
    @Autowired
    private CategoryBookRepository categoryBookRepo;

    @Override
    public List<CategoryBook> getCategoryBooks() {
        return categoryBookRepo.findAll();
    }

    @Override
    public boolean insertCategoryBook(CategoryBook categoryBook) {
        try{
            categoryBookRepo.save(categoryBook);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCategoryBook(CategoryBook categoryBook) {
        categoryBookRepo.findById(categoryBook.getCateBookId()).orElseThrow(()-> new NoSuchElementException("Khong ton tai category book!"));
        try{
            categoryBookRepo.save(categoryBook);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCategoryBookById(String cateBookId) {
        try{
            categoryBookRepo.deleteById(cateBookId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public CategoryBook getCategoryBookById(String cateBookId) {
        return categoryBookRepo.findById(cateBookId).orElseThrow(()-> new NoSuchElementException("Khong ton tai category book!"));
    }

    @Override
    public List<CategoryBook> getCategoryBooksByCategoryName(String categoryName) {
        return categoryBookRepo.findCategoryBooksByCateBookNameContains(categoryName);
    }

}
