package com.joverpenalva.proyectospringboot.controllers;

import com.joverpenalva.proyectospringboot.models.entities.Trabajador;
import com.joverpenalva.proyectospringboot.models.services.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view/trabajadores")
public class TrabajadorViewController {

    @Autowired
    private ITrabajadorService trabajadorService;

    @GetMapping
    public String listTrabajadores(Model model) {
        List<Trabajador> trabajadores = trabajadorService.findAll();
        model.addAttribute("trabajadores", trabajadores);
        return "trabajadores/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        return "trabajadores/create";
    }

    @PostMapping("/create")
    public String createTrabajador(@RequestParam("idTrabajador") String id, @ModelAttribute Trabajador trabajador) {
        // Asigna el ID proporcionado por el usuario al trabajador
        trabajador.setIdTrabajador(id);
        
        // Guarda el trabajador en la base de datos
        trabajadorService.save(trabajador);
        
        // Redirige a la página de visualización de trabajadores
        return "redirect:/view/trabajadores";
    }



    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Trabajador trabajador = trabajadorService.findById(id);
        if (trabajador == null) {
            return "redirect:/view/trabajadores";
        }
        model.addAttribute("trabajador", trabajador);
        return "trabajadores/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateTrabajador(@PathVariable String id, @ModelAttribute Trabajador trabajador) {
        Trabajador existingTrabajador = trabajadorService.findById(id);
        if (existingTrabajador == null) {
            return "redirect:/view/trabajadores";
        }
        existingTrabajador.setDni(trabajador.getDni());
        existingTrabajador.setNombre(trabajador.getNombre());
        existingTrabajador.setApellidos(trabajador.getApellidos());
        existingTrabajador.setEspecialidad(trabajador.getEspecialidad());
        existingTrabajador.setContraseña(trabajador.getContraseña());
        existingTrabajador.setEmail(trabajador.getEmail());
        trabajadorService.save(existingTrabajador);
        return "redirect:/view/trabajadores";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrabajador(@PathVariable String id) {
        trabajadorService.deleteById(id);
        return "redirect:/view/trabajadores";
    }
}