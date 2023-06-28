package com.zaxx.KnottingAround.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_venta")
@IdClass(OrderAmigurumiId.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderAmigurumiEntity {
    @Id
    @Column(name="id_venta")
    private Integer idVenta;
    @Id
    @Column(name="id_amigurumi")
    private Integer idAmigurumi;
    @Column
    private Double precio;
    @Column
    private Double descuento;
    @Column
    private Integer cantidad;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_venta",referencedColumnName = "id",insertable = false,updatable = false)
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "id_amigurumi",referencedColumnName = "id",updatable = false,insertable = false)
    private AmigurumiEntity amigurumi;
}
