package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.domain.orderDto.OrderUpdateEstadoDto;
import com.zaxx.KnottingAround.persistence.entity.OrderEntity;
import com.zaxx.KnottingAround.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }
    @GetMapping("/getApproved")
    public ResponseEntity<List<OrderEntity>> getAllAproved(){
        return ResponseEntity.ok(orderService.getAllApproved());
    }
    @GetMapping("/getNotApproved")
    public ResponseEntity<List<OrderEntity>> getAllNotAproved(){
        return ResponseEntity.ok(orderService.getAllNotApproved());
    }
    @PutMapping("/updateEstado")
    public ResponseEntity<Void> updateEstado(@RequestBody OrderUpdateEstadoDto orderUpdateEstadoDto){
        orderService.updateEstadoOrder(orderUpdateEstadoDto);
        return ResponseEntity.ok().build();
    }
}
