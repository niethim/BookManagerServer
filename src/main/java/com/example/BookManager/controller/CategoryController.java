package com.example.BookManager.controller;

import com.example.BookManager.dto.requests.CreateCategoryRequest;
import com.example.BookManager.dto.responses.ApiResponse;
import com.example.BookManager.entity.books;
import com.example.BookManager.entity.categories;
import com.example.BookManager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping()
    ApiResponse<categories> CreateCategory(@RequestBody CreateCategoryRequest request)
    {
        ApiResponse<categories> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.CreateCategory(request));
        return apiResponse;
    }
    @GetMapping()
    List<categories> ReadCategories()
    {
        return categoryService.readCategories();
    }
}
