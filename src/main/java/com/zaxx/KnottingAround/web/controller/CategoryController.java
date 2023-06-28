package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.persistence.entity.CategoryEntity;
import com.zaxx.KnottingAround.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping()
    public ResponseEntity<List<CategoryEntity>> getAll(){
        return ResponseEntity.ok(this.categoryService.getAll());
    }
}
