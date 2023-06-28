package com.zaxx.KnottingAround.persistence.repository;

import com.zaxx.KnottingAround.persistence.entity.AmigurumiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmigurumiRepository extends JpaRepository<AmigurumiEntity,Integer> {
    List<AmigurumiEntity> findByEstadoTrueAndStockGreaterThan(int mayorque);
    List<AmigurumiEntity> findByIdCategoria(int categoria);
}
