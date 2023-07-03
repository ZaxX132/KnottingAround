package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.persistence.entity.CategoryEntity;
import com.zaxx.KnottingAround.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/admin/new")
    public ResponseEntity<CategoryEntity> createNew(@RequestBody CategoryEntity category){
        if(category.getId()==null || !categoryService.exists(category.getId())){
            return ResponseEntity.ok(categoryService.save(category));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/admin/update")
    public ResponseEntity<CategoryEntity> update(@RequestBody CategoryEntity category){
        if(category.getId()!=null && categoryService.exists(category.getId())){
            return ResponseEntity.ok(categoryService.save(category));
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/admin/delete")
    public ResponseEntity<Void> delete(@RequestParam int id){
        if(categoryService.exists(id)){
            categoryService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
