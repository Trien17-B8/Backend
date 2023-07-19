package com.example.backend.controller;

import com.example.backend.exception.ResponseObject;
import com.example.backend.models.Category;
import com.example.backend.service.ICategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
