package com.example.biblioteca.service;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro obtenerPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }
}