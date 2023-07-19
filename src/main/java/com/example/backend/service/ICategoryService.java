package com.example.backend.service;

import com.example.backend.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();

    Category create(Category category);
}
