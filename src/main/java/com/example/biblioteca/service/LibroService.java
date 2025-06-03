package com.example.biblioteca.service;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Libro guardar(Libro libro) {
        validarAnio(libro.getAnioPublicacion());
        return libroRepository.save(libro);
    }

    public Libro obtenerPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    public Libro actualizar(Long id, Libro libroActualizado) {
        return libroRepository.findById(id).map(libro -> {
            validarAnio(libroActualizado.getAnioPublicacion());
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setAnioPublicacion(libroActualizado.getAnioPublicacion());
            return libroRepository.save(libro);
        }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private void validarAnio(int anio) {
        int anioActual = Year.now().getValue();
        System.out.println("Validando año: " + anio + ", Año actual: " + anioActual);
        if (anio > anioActual) {
            throw new IllegalArgumentException("El año no puede ser mayor al actual (" + anioActual + ")");
        }
        if (anio < 1500) {
            throw new IllegalArgumentException("El año no puede ser menor a 1500");
        }
    }
}