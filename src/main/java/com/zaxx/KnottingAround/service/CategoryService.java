package com.zaxx.KnottingAround.service;

import com.zaxx.KnottingAround.persistence.entity.CategoryEntity;
import com.zaxx.KnottingAround.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<CategoryEntity> getAll(){
        return this.categoryRepository.findAll();
    }
    public CategoryEntity save(CategoryEntity categoryEntity){
        return this.categoryRepository.save(categoryEntity);
    }
    public Boolean exists(int id){
        return this.categoryRepository.existsById(id);
    }
    public void delete(int id){
        this.categoryRepository.deleteById(id);
    }
}
