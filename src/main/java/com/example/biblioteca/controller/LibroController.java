package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
        System.out.println("Se ha echo una consulta en la API, by Kevin");
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.guardar(libro);
    }

    @GetMapping("/{id}")
    public Libro obtenerLibro(@PathVariable Long id) {
        return libroService.obtenerPorId(id);
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.listarTodos();
    }
}