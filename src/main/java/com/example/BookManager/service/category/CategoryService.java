package com.example.BookManager.service.category;

import com.example.BookManager.dto.requests.CreateCategoryRequest;
import com.example.BookManager.entity.categories;
import com.example.BookManager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public categories CreateCategory(CreateCategoryRequest request)
    {
        categories category = new categories();
        category.setCategoryName(request.getCategoryName());
        return categoryRepository.save(category);
    }
    public List<categories> readCategories()
    {
        return categoryRepository.findAll();
    }
    public categories findByCategoryID(long CategoryID)
    {
        return categoryRepository.findById(CategoryID)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
    public String getMostPopularCategory()
    {
        return categoryRepository.findMostPopularCategory();
    }
}
