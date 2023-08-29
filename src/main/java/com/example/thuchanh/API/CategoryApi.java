package com.example.thuchanh.API;

import com.example.thuchanh.model.Author;
import com.example.thuchanh.model.Category;
import com.example.thuchanh.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryApi {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAll (){
        return  categoryService.findAll();
    }
}
