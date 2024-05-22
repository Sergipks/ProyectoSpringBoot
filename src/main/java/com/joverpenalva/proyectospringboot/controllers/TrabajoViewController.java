package com.joverpenalva.proyectospringboot.controllers;

import com.joverpenalva.proyectospringboot.models.entities.Trabajador;
import com.joverpenalva.proyectospringboot.models.entities.Trabajo;
import com.joverpenalva.proyectospringboot.models.services.ITrabajadorService;
import com.joverpenalva.proyectospringboot.models.services.ITrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("view/trabajos")
public class TrabajoViewController {

    @Autowired
    private ITrabajoService trabajoService;
    
    @Autowired
    private ITrabajadorService trabajadorService;
    
    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @GetMapping
    public String listTrabajos(Model model) {
        List<Trabajo> trabajos = trabajoService.findAll();
        model.addAttribute("trabajos", trabajos);
        return "trabajos/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
    	List<Trabajador> trabajadores = trabajadorService.findAll();
        model.addAttribute("trabajo", new Trabajo());
        model.addAttribute("trabajadores", trabajadores);
        return "trabajos/create";
    }

    @PostMapping("/create")
    public String createTrabajo(@ModelAttribute Trabajo trabajo) {
    	trabajo.setFechaInicio(new Date());
        trabajoService.save(trabajo);
        return "redirect:/view/trabajos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Trabajo trabajo = trabajoService.findById(id);
        if (trabajo == null) {
            return "redirect:/view/trabajos";
        }
        model.addAttribute("trabajo", trabajo);
        return "trabajos/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateTrabajo(@PathVariable String id, @ModelAttribute Trabajo trabajo) {
        Trabajo existingTrabajo = trabajoService.findById(id);
        
        if (existingTrabajo == null) {
            return "redirect:/view/trabajos";
        }
        
        existingTrabajo.setDescripcion(trabajo.getDescripcion());
        existingTrabajo.setFechaFin(trabajo.getFechaFin());
        existingTrabajo.setTiempo(trabajo.getTiempo());
        existingTrabajo.setPrioridad(trabajo.getPrioridad());

        trabajoService.save(existingTrabajo);
        
        return "redirect:/view/trabajos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrabajo(@PathVariable String id) {
        trabajoService.deleteById(id);
        return "redirect:/view/trabajos";
    }
}
