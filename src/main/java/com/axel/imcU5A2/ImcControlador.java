package com.axel.imcU5A2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImcControlador {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam("peso") double p, 
                           @RequestParam("estatura") double e,
                           Model model) {
        
        try {
            Persona usuario = new Persona(p, e);
            double valorImc = usuario.calcularIMC();
            String diagnostico = usuario.obtenerDiagnostico(valorImc);

            model.addAttribute("resultado", "Tu IMC es " + valorImc + " - " + diagnostico);
        } catch (Exception err) {
            model.addAttribute("resultado", "Error: Por favor ingresa datos validos.");
        }
        return "index";
    }
}
