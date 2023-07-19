package com.example.backend.service.Impl;

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
    public Category create(Category category) {
        return iCategoryRepository.save(category);
    }
}
