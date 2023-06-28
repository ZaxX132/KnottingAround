package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.persistence.entity.AmigurumiEntity;
import com.zaxx.KnottingAround.service.AmigurumiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/amigurumi")
public class AmigurumiController {
    private final AmigurumiService amigurumiService;

    public AmigurumiController(AmigurumiService amigurumiService) {
        this.amigurumiService = amigurumiService;
    }
    @GetMapping("/getAvailable")
    public ResponseEntity<List<AmigurumiEntity>> getAllAvailable(){
        return ResponseEntity.ok(amigurumiService.getAllAvailable());
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<AmigurumiEntity>> getAll(){
        return ResponseEntity.ok(amigurumiService.getAllAvailable());
    }
    @GetMapping("/byCategoria/{id}")
    public ResponseEntity<List<AmigurumiEntity>> getByCategoria(@PathVariable int id){
        return ResponseEntity.ok(amigurumiService.getByCategoria(id));
    }
}
