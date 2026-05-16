package com.second.api.services;

import com.second.api.dto.ArticuloDTO;
import com.second.api.models.Articulo;
import com.second.api.models.Categoria;
import com.second.api.repositories.ArticuloRepository;
import com.second.api.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<ArticuloDTO> obtenerTodos() {
        return articuloRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public ArticuloDTO guardarArticulo(ArticuloDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Articulo articulo = new Articulo();
        articulo.setNombre(dto.getNombre());
        articulo.setStock(dto.getStock());
        articulo.setPrecio(dto.getPrecio());
        articulo.setCategoria(categoria);

        return convertirADTO(articuloRepository.save(articulo));
    }

    public ArticuloDTO actualizarArticulo(Long id, ArticuloDTO dto) {
        Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
                
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        articulo.setNombre(dto.getNombre());
        articulo.setStock(dto.getStock());
        articulo.setPrecio(dto.getPrecio());
        articulo.setCategoria(categoria);

        return convertirADTO(articuloRepository.save(articulo));
    }

    public void eliminarArticulo(Long id) {
        if (!articuloRepository.existsById(id)) {
            throw new RuntimeException("Artículo no encontrado");
        }
        // Acá hacemos borrado físico directo, la consigna pide algo simplificado.
        articuloRepository.deleteById(id);
    }

    private ArticuloDTO convertirADTO(Articulo articulo) {
        ArticuloDTO dto = new ArticuloDTO();
        dto.setId(articulo.getId());
        dto.setNombre(articulo.getNombre());
        dto.setStock(articulo.getStock());
        dto.setPrecio(articulo.getPrecio());
        dto.setCategoriaId(articulo.getCategoria().getId());
        dto.setCategoriaNombre(articulo.getCategoria().getNombre());
        return dto;
    }
}