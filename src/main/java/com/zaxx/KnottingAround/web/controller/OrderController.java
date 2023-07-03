package com.zaxx.KnottingAround.web.controller;

import com.zaxx.KnottingAround.domain.dto.orderDto.CustomerNewOrder;
import com.zaxx.KnottingAround.domain.dto.orderDto.OrderUpdateEstadoDto;
import com.zaxx.KnottingAround.excepcions.orderExcepsions.AmigurumiNotExistsException;
import com.zaxx.KnottingAround.excepcions.orderExcepsions.AmigurumiOutOfStock;
import com.zaxx.KnottingAround.persistence.entity.OrderEntity;
import com.zaxx.KnottingAround.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PutMapping("/customer/newOrder")
    public ResponseEntity<Void> newOrder(@RequestBody CustomerNewOrder newOrder, Authentication authentication)
            throws AmigurumiNotExistsException, AmigurumiOutOfStock {
        orderService.newOrder(newOrder,authentication);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/customer/getOrders")
    public ResponseEntity<List<OrderEntity>> getByUserName(Authentication authentication){
        return ResponseEntity.ok(orderService.getOrderByUser(authentication.getPrincipal().toString()));
    }

    @GetMapping("/admin/getAll")
    public ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }
    @GetMapping("/admin/getOrders")
    public ResponseEntity<List<OrderEntity>> getAllByUsername(@RequestParam String username){
        return ResponseEntity.ok(orderService.getOrderByUser(username));
    }
    @GetMapping("/admin/getApproved")
    public ResponseEntity<List<OrderEntity>> getAllAproved(){
        return ResponseEntity.ok(orderService.getAllApproved());
    }
    @GetMapping("/admin/getNotApproved")
    public ResponseEntity<List<OrderEntity>> getAllNotAproved(){
        return ResponseEntity.ok(orderService.getAllNotApproved());
    }
    @PostMapping("/admin/updateEstado")
    public ResponseEntity<Void> updateEstado(@RequestBody OrderUpdateEstadoDto orderUpdateEstadoDto){
        orderService.updateEstadoOrder(orderUpdateEstadoDto);
        return ResponseEntity.ok().build();
    }

}
