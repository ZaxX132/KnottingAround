package com.zaxx.KnottingAround.service;

import com.zaxx.KnottingAround.domain.dto.orderDto.CustomerNewOrder;
import com.zaxx.KnottingAround.domain.dto.orderDto.OrderUpdateEstadoDto;
import com.zaxx.KnottingAround.domain.dto.orderDto.orderAmigurumis;
import com.zaxx.KnottingAround.excepcions.orderExcepsions.AmigurumiNotExistsException;
import com.zaxx.KnottingAround.excepcions.orderExcepsions.AmigurumiOutOfStock;
import com.zaxx.KnottingAround.persistence.entity.AmigurumiEntity;
import com.zaxx.KnottingAround.persistence.entity.OrderAmigurumiEntity;
import com.zaxx.KnottingAround.persistence.entity.OrderEntity;
import com.zaxx.KnottingAround.persistence.repository.AmigurumiRepository;
import com.zaxx.KnottingAround.persistence.repository.OrderAmigurumiRepository;
import com.zaxx.KnottingAround.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final AmigurumiRepository amigurumiRepository;
    private final OrderAmigurumiRepository orderAmigurumiRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository, AmigurumiRepository amigurumiRepository, OrderAmigurumiRepository orderAmigurumiRepository) {
        this.orderRepository = orderRepository;
        this.amigurumiRepository = amigurumiRepository;
        this.orderAmigurumiRepository = orderAmigurumiRepository;
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
    public List<OrderEntity> getOrderByUser(String usuario){
        return this.orderRepository.findByUsuario(usuario);
    }
    @Transactional
    public void updateEstadoOrder(OrderUpdateEstadoDto orderUpdateEstadoDto){
        this.orderRepository.actualizarEstado(orderUpdateEstadoDto.getId(),orderUpdateEstadoDto.getEstado());
    }
    @Transactional
    public void newOrder(CustomerNewOrder newOrder, Authentication authentication) throws AmigurumiNotExistsException, AmigurumiOutOfStock {
        double total=0;
        List<OrderAmigurumiEntity> amigurumis=new ArrayList<>();

        AmigurumiEntity amigurumiTemporal;
        LocalDateTime requestDate= LocalDateTime.now();
        //Se crea el orderEntity y se le colocan los atributos principales
        OrderEntity order=new OrderEntity();
        OrderEntity savedOrder;
        order.setUsuario(authentication.getPrincipal().toString());
        order.setMetodo(newOrder.getMetodo());
        order.setComentario(newOrder.getComentario());
        order.setFechaSolicitud(requestDate);
        //Se revisará si los amigurumis que se nos enviaron existen y tienen stock
        for (orderAmigurumis amigurumi: newOrder.getAmigurumis()) {
            OrderAmigurumiEntity detalleAmigurumi=new OrderAmigurumiEntity();
            if(!amigurumiRepository.existsById(amigurumi.getIdAmigurumi())){
                throw  new AmigurumiNotExistsException("this amigurumi does not exist");
            }
            amigurumiTemporal= amigurumiRepository.getReferenceById(amigurumi.getIdAmigurumi());
            if(amigurumiTemporal.getStock()<amigurumi.getCantidad()){
                throw new AmigurumiOutOfStock("amigurumi out of stock");
            }
            //Se calcula el precio total ademas de actualizar el stock de los amigurumis
            amigurumiTemporal.setStock(amigurumiTemporal.getStock()-amigurumi.getCantidad());
            total=total+(amigurumiTemporal.getPrecio()-(amigurumiTemporal.getPrecio()*amigurumiTemporal.getDescuento()))*amigurumi.getCantidad();
            amigurumiRepository.save(amigurumiTemporal);
            //Se empieza a guardar el detalle de los amigurumis en el objeto temporal detalle
            detalleAmigurumi.setIdAmigurumi(amigurumiTemporal.getId());
            detalleAmigurumi.setPrecio(amigurumiTemporal.getPrecio());
            detalleAmigurumi.setDescuento(amigurumiTemporal.getDescuento());
            detalleAmigurumi.setCantidad(amigurumi.getCantidad());
            //Se guarda el objeto temporal en la lista del detalle de la venta
            amigurumis.add(detalleAmigurumi);
        }
        order.setTotal(total);
        order.setEstado(false);
        savedOrder=this.orderRepository.save(order);
        for (OrderAmigurumiEntity detalle: amigurumis) {
            detalle.setIdVenta(savedOrder.getId());
        }
        this.orderAmigurumiRepository.saveAll(amigurumis);
    }
}
