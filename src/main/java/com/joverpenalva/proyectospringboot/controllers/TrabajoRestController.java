package com.joverpenalva.proyectospringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joverpenalva.proyectospringboot.models.entities.Trabajo;
import com.joverpenalva.proyectospringboot.models.services.ITrabajoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/trabajos")
public class TrabajoRestController {
	
	@Autowired
	private ITrabajoService trabajoService;
	
	@GetMapping
	public List<Trabajo> index(){
		return trabajoService.findAll();
	}
	
	@PostMapping
    public Trabajo create(@RequestBody Trabajo trabajo) {
        return trabajoService.save(trabajo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajo> update(@PathVariable String id, @RequestBody Trabajo trabajo) {
        Trabajo existingTrabajo = trabajoService.findById(id);
        if (existingTrabajo == null) {
            return ResponseEntity.notFound().build();
        }
        trabajo.setCodTrabajo(id);
        Trabajo updatedTrabajo = trabajoService.save(trabajo);
        return ResponseEntity.ok(updatedTrabajo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Trabajo trabajo = trabajoService.findById(id);
        if (trabajo == null) {
            return ResponseEntity.notFound().build();
        }
        trabajoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/pendientes/trabajador")
    public ResponseEntity<List<Trabajo>> getTrabajosPendientes(@RequestParam String idTrabajador, @RequestParam String contraseña) {
        List<Trabajo> trabajosPendientes = trabajoService.findPendientesTrabajador(idTrabajador, contraseña);
        if (trabajosPendientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trabajosPendientes);
    }
    
    @GetMapping("/finalizados/trabajador")
    public ResponseEntity<List<Trabajo>> getTrabajosFinalizados(@RequestParam String idTrabajador, @RequestParam String contraseña) {
        List<Trabajo> trabajosFinalizados = trabajoService.findFinalizadosTrabajador(idTrabajador, contraseña);
        if (trabajosFinalizados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trabajosFinalizados);
    }
    
    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Trabajo> finalizarTrabajo(@PathVariable String id) {
    	Trabajo trabajoFinalizado = trabajoService.finalizarTrabajo(id);
        if (trabajoFinalizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trabajoFinalizado);
    }
    
    @PutMapping("/{idTrabajo}/asignar/{idTrabajador}")
    public ResponseEntity<?> asignarTrabajo(@PathVariable String idTrabajo, @PathVariable String idTrabajador) {
    	int resultado = trabajoService.asignarTrabajo(idTrabajo, idTrabajador);
        
    	if (resultado == -1) {
            return ResponseEntity.notFound().build();
        }

        if (resultado == -2) {
            return ResponseEntity.badRequest().body("La categoría del trabajo y la especialidad del trabajador no coinciden");
        }
    	
        return ResponseEntity.ok().build();
    }
}
