package com.zaxx.KnottingAround.service;

import com.zaxx.KnottingAround.domain.orderDto.OrderUpdateEstadoDto;
import com.zaxx.KnottingAround.persistence.entity.OrderEntity;
import com.zaxx.KnottingAround.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<OrderEntity> getAll(){
        return this.orderRepository.findAll();
    }
    public List<OrderEntity> getAllApproved(){
        return this.orderRepository.findByEstadoTrue();
    }
    public List<OrderEntity> getAllNotApproved(){
        return this.orderRepository.findByEstadoFalse();
    }
    @Transactional
    public void updateEstadoOrder(OrderUpdateEstadoDto orderUpdateEstadoDto){
        this.orderRepository.actualizarEstado(orderUpdateEstadoDto.getId(),orderUpdateEstadoDto.getEstado());
    }
}
