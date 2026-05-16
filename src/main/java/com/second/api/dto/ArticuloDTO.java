package com.second.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ArticuloDTO {
    private Long id;

    @NotBlank(message = "El nombre del artículo no puede estar vacío")
    private String nombre;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Double precio;

    @NotNull(message = "Debe asignar una categoría (ID)")
    private Long categoriaId;
    
    // Solo para devolver el nombre al hacer GET
    private String categoriaNombre; 
}