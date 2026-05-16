package com.second.api.controllers;

import com.second.api.dto.ArticuloDTO;
import com.second.api.services.ArticuloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public ResponseEntity<List<ArticuloDTO>> listarArticulos() {
        return ResponseEntity.ok(articuloService.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<ArticuloDTO> crearArticulo(@Valid @RequestBody ArticuloDTO articuloDTO) {
        return new ResponseEntity<>(articuloService.guardarArticulo(articuloDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticuloDTO> modificarArticulo(@PathVariable Long id, @Valid @RequestBody ArticuloDTO articuloDTO) {
        return ResponseEntity.ok(articuloService.actualizarArticulo(id, articuloDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarArticulo(@PathVariable Long id) {
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }
}