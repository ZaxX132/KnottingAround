package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.persistence.entity.AmigurumiEntity;
import com.zaxx.KnottingAround.service.AmigurumiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/admin/new")
    public ResponseEntity<AmigurumiEntity> createNew(@RequestBody AmigurumiEntity amigurumi){
        if(amigurumi.getId()==null || !this.amigurumiService.exists(amigurumi.getId())){
            return ResponseEntity.ok(amigurumiService.save(amigurumi));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/admin/update")
    public ResponseEntity<AmigurumiEntity> update(@RequestBody AmigurumiEntity amigurumi){
        if(amigurumi.getId()!=null && this.amigurumiService.exists(amigurumi.getId())){
            return ResponseEntity.ok(amigurumiService.save(amigurumi));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        if(amigurumiService.exists(id)){
            amigurumiService.delete(id);
           return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
