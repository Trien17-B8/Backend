package com.example.backend.service.Impl;

import com.example.backend.dto.request.CategoryRequest;
import com.example.backend.models.Category;
import com.example.backend.repository.ICategoryRepository;
import com.example.backend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;


    @Override
    public List<Category> getAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(String id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public Category create(CategoryRequest categoryRequest) {
        Category category = new Category(null, categoryRequest.getMa(), categoryRequest.getTen());
        return iCategoryRepository.save(category);
    }

    @Override
    public void remove(String id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public Category update(String id, CategoryRequest categoryRequest) {
        Category category1 = findById(id);
        category1.setMa(categoryRequest.getMa());
        category1.setTen(categoryRequest.getTen());
        return iCategoryRepository.save(category1);
    }
}
