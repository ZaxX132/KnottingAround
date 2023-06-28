package com.zaxx.KnottingAround.service;

import com.zaxx.KnottingAround.persistence.entity.AmigurumiEntity;
import com.zaxx.KnottingAround.persistence.repository.AmigurumiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmigurumiService {
    private final AmigurumiRepository amigurumiRepository;

    public AmigurumiService(AmigurumiRepository amigurumiRepository) {
        this.amigurumiRepository = amigurumiRepository;
    }
    public List<AmigurumiEntity> getAll(){
        return this.amigurumiRepository.findAll();
    }
    public List<AmigurumiEntity> getAllAvailable(){
        return this.amigurumiRepository.findByEstadoTrueAndStockGreaterThan(0);
    }
    public List<AmigurumiEntity> getByCategoria(int categoria){
        return this.amigurumiRepository.findByIdCategoria(categoria);
    }
}
