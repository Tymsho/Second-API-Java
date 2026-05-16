package com.second.api.config;

import com.second.api.models.Categoria;
import com.second.api.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventarioSeeder implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoriaRepository.count() == 0) {
            Categoria c1 = new Categoria();
            c1.setNombre("Librería General");
            c1.setDescripcion("Artículos básicos de papelería");

            Categoria c2 = new Categoria();
            c2.setNombre("Tecnología e Insumos");
            c2.setDescripcion("Periféricos y componentes");

            Categoria c3 = new Categoria();
            c3.setNombre("Mantenimiento");
            c3.setDescripcion("Productos de limpieza de oficina");

            categoriaRepository.saveAll(List.of(c1, c2, c3));
            System.out.println("Categorías de inventario inicializadas.");
        }
    }
}