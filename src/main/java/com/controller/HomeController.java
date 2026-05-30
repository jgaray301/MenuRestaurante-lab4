package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.repository.ComidaRepository;

@Controller
public class HomeController {

    @Autowired
    private ComidaRepository repo;

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("comidas", repo.findAll());

        return "index";
    }
}