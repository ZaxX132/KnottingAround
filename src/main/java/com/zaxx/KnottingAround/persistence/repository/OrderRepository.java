package com.zaxx.KnottingAround.persistence.repository;

import com.zaxx.KnottingAround.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    List<OrderEntity> findByEstadoFalse();
    List<OrderEntity> findByEstadoTrue();
    @Procedure(value = "actualizar_estado_de_ventar")
    void actualizarEstado(@Param("idOrder")int idOrder,@Param("state") boolean estado);
    List<OrderEntity> findByUsuario(String usuario);

}
