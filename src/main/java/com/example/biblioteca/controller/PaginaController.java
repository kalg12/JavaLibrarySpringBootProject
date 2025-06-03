package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaginaController {

    private final LibroService libroService;

    public PaginaController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Mostrar todos los libros
    @GetMapping("/")
    public String verPagina(Model model) {
        model.addAttribute("libros", libroService.listarTodos());
        return "index";
    }

    // Mostrar formulario para editar
    @GetMapping("/libros/editar/{id}")
    public String editarLibro(@PathVariable Long id, Model model) {
        Libro libro = libroService.obtenerPorId(id);
        model.addAttribute("libro", libro);
        return "editar";
    }

    // Guardar nuevo libro (desde formulario)
    @PostMapping("/libros")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroService.guardar(libro);
        return "redirect:/";
    }

    // Actualizar libro (formulario editar)
    @PostMapping("/libros/actualizar/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute Libro libro) {
        libroService.actualizar(id, libro);
        return "redirect:/";
    }

    // Eliminar libro
    @GetMapping("/libros/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.eliminar(id);
        return "redirect:/";
    }
}