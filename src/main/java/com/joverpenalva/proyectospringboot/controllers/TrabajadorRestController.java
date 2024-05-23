package com.joverpenalva.proyectospringboot.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joverpenalva.proyectospringboot.models.entities.Trabajador;
import com.joverpenalva.proyectospringboot.models.services.ITrabajadorService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "api/trabajadores", produces = "application/json;charset=UTF-8")
public class TrabajadorRestController {
	
	@Autowired
	private ITrabajadorService trabajadorService;
	
	@GetMapping
	public ResponseEntity<Object> getTrabajadores() {
	    List<Trabajador> trabajadores = trabajadorService.findAll();
	    if (trabajadores.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron trabajadores.");
	    }
	    Map<String, Object> responseBody = new HashMap<>();
	    responseBody.put("status", HttpStatus.OK.value());
	    responseBody.put("message", "Success");
	    responseBody.put("result", trabajadores);
	    return ResponseEntity.ok(responseBody);
	}
	
	@PostMapping
    public ResponseEntity<Object> createTrabajador(@RequestBody Trabajador trabajador) {
        Trabajador createdTrabajador = trabajadorService.save(trabajador);
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.CREATED.value());
        responseBody.put("message", "Trabajador creado exitosamente");
        responseBody.put("result", createdTrabajador);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTrabajador(@PathVariable String id, @RequestBody Trabajador trabajador) {
	    Trabajador existingTrabajador = trabajadorService.findById(id);
	    if (existingTrabajador == null) {
	        Map<String, Object> responseBody = new HashMap<>();
	        responseBody.put("status", HttpStatus.NOT_FOUND.value());
	        responseBody.put("message", "Trabajador no encontrado");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
	    }
	    existingTrabajador.setDni(trabajador.getDni());
	    existingTrabajador.setNombre(trabajador.getNombre());
	    existingTrabajador.setApellidos(trabajador.getApellidos());
	    existingTrabajador.setEspecialidad(trabajador.getEspecialidad());
	    existingTrabajador.setContraseña(trabajador.getContraseña());
	    existingTrabajador.setEmail(trabajador.getEmail());	    
	    Trabajador updatedTrabajador = trabajadorService.save(existingTrabajador);    
	    Map<String, Object> responseBody = new HashMap<>();
	    responseBody.put("status", HttpStatus.OK.value());
	    responseBody.put("message", "Trabajador actualizado exitosamente");
	    responseBody.put("result", updatedTrabajador);	    
	    return ResponseEntity.ok(responseBody);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTrabajador(@PathVariable String id) {
	    Trabajador trabajador = trabajadorService.findById(id);
	    if (trabajador == null) {
	        Map<String, Object> responseBody = new HashMap<>();
	        responseBody.put("status", HttpStatus.NOT_FOUND.value());
	        responseBody.put("message", "Trabajador no encontrado");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
	    } 
	    trabajadorService.deleteById(id);    
	    Map<String, Object> responseBody = new HashMap<>();
	    responseBody.put("status", HttpStatus.OK.value());
	    responseBody.put("message", "Trabajador eliminado exitosamente");	    
	    return ResponseEntity.ok(responseBody);
	}


	
}
