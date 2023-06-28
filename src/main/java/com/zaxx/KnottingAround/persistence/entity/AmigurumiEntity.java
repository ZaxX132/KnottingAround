package com.zaxx.KnottingAround.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "amigurumis")
@Getter
@Setter
@NoArgsConstructor
public class AmigurumiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private Integer stock;
    @Column
    private Double precio;
    @Column
    private Double descuento;
    @Column(name = "cate_id")
    private Integer idCategoria;
    @Column
    private Boolean estado;
    @OneToOne
    @JoinColumn(name = "cate_id",referencedColumnName = "id",insertable = false,updatable = false)
    private CategoryEntity categoria;
}
