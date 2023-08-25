package com.example.backend.service;

import com.example.backend.dto.request.CategoryRequest;
import com.example.backend.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();

    Category findById(String id);

    Category create(CategoryRequest categoryRequest);

    void remove(String id);

    Category update(String id, CategoryRequest categoryRequest);
}
