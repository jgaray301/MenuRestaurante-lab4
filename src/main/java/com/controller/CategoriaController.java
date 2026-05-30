package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.model.Categoria;
import com.repository.CategoriaRepository;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repo;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("categorias", repo.findAll());
        return "categorias/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @PostMapping("/guardar")
    public String guardar(Categoria categoria){
        repo.save(categoria);
        return "redirect:/categorias";
    }
}