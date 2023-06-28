package com.zaxx.KnottingAround.persistence.repository;

import com.zaxx.KnottingAround.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
