package com.example.biblioteca.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ManejadorErrores {

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView manejarErrorDeValidacion(IllegalArgumentException ex, Model model) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("mensaje", ex.getMessage());
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView manejarErrorGeneral(Exception ex) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("mensaje", "Ocurrió un error inesperado: " + ex.getMessage());
        return mav;
    }
}