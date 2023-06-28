package com.zaxx.KnottingAround.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String usuario;
    @Column
    private String metodo;
    @Column
    private String comentario;
    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;
    @Column(name = "fecha_aprobacion")
    private LocalDateTime fechaAprobacion;
    @Column
    private Double total;
    @Column
    private Boolean estado;

    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private List<OrderAmigurumiEntity> amigurumis;
}
