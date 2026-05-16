package com.second.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "articulos")
@Data
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private Integer stock;
    
    private Double precio;

    // Relación ManyToOne para cumplir con el requisito de 2-3 entidades
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}