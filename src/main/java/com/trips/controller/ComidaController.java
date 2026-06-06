package com.trips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.trips.model.Comida;
import com.trips.repository.CategoriaRepository;
import com.trips.repository.ComidaRepository;

@Controller
@RequestMapping("/comidas")
public class ComidaController {

    @Autowired
    private ComidaRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("comidas", repo.findAll());
        return "comidas/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("comida", new Comida());
        model.addAttribute("categorias", categoriaRepo.findAll());
        return "comidas/form";
    }

    @PostMapping("/guardar")
    public String guardar(Comida comida){
        repo.save(comida);
        return "redirect:/comidas";
    }
}