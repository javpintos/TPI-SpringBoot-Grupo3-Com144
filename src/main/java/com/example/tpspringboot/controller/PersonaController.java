package com.example.tpspringboot.controller;
import com.example.tpspringboot.entity.Persona;
import com.example.tpspringboot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/viewPersonas")
    public String viewBooks(Model model) {
        model.addAttribute("personas", personaService.getAllPersonas());
        return "view-personas";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "saludo";
    }
}