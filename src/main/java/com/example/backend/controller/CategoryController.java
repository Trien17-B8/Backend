package com.example.backend.controller;

import com.example.backend.dto.request.CategoryRequest;
import com.example.backend.exception.ResponseObject;
import com.example.backend.models.Category;
import com.example.backend.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Tag(name = "[Category]")
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/all")
    @Operation(summary = "[Get All List Category]")
    private ResponseEntity<ResponseObject> findAll(){
        List<Category> listCategory = iCategoryService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseObject(HttpStatus.OK, "findAll Successfully", listCategory));
    }


    @PostMapping("/create")
    @Operation(summary = "[Create New Category]")
    private ResponseEntity<ResponseObject> create(@RequestBody @Valid CategoryRequest categoryRequest){
        Category category = iCategoryService.create(categoryRequest);
//        if(categoryRequest.getMa().isEmpty() || categoryRequest.getTen().isEmpty()){
//            throw new ValidationException("Ma or Ten isEmpty");
//        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseObject(HttpStatus.OK, "Create New Category Successfully", category));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "[Remove Category]")
    private ResponseEntity<ResponseObject> remove(@PathVariable String id){
        iCategoryService.remove(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseObject(HttpStatus.OK, "Remove Category Successfully", iCategoryService.getAll()));
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "[Update Category]")
    private ResponseEntity<ResponseObject> update(@PathVariable String id, @RequestBody @Valid CategoryRequest categoryRequest){
        iCategoryService.update(id, categoryRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseObject(HttpStatus.OK, "Update Category Successfully", iCategoryService.getAll()));

    }

}
