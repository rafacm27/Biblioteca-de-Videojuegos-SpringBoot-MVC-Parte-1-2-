package com.app.videogames.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.app.videogames.model.Videojuego;
import com.app.videogames.service.VideojuegoService;

@Controller
public class VideojuegoController {
    
    private final VideojuegoService service;

    public VideojuegoController(VideojuegoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("juegos", service.findAll());
        return "index";
    }

    @GetMapping("/plataforma/{nombre}")
    public String plataforma(@PathVariable String nombre, Model model) {
        model.addAttribute("nombrePlataforma", nombre.replace("-", " "));
        model.addAttribute("juegos", service.findByPlataforma(nombre.replace("-", " ")));
        return "plataformas";
    }

    @GetMapping("/juego/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Videojuego juego = service.findById(id);
        if (juego == null) return "redirect:/";
        model.addAttribute("juego", juego);
        return "detalle";
    }

    @GetMapping("/juego/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("juego", new Videojuego());
        return "formulario";
    }

    @PostMapping("/juego/guardar")
    public String guardar(@ModelAttribute("juego") Videojuego videojuego) {
        service.save(videojuego);
        return "redirect:/";
    }

    @GetMapping("/juego/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Videojuego juego = service.findById(id);
        if (juego == null) return "redirect:/";
        model.addAttribute("juego", juego);
        return "formulario";
    }
}
