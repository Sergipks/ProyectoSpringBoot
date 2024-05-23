package com.joverpenalva.proyectospringboot.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joverpenalva.proyectospringboot.models.entities.Trabajador;
import com.joverpenalva.proyectospringboot.models.entities.Trabajo;
import com.joverpenalva.proyectospringboot.models.services.ITrabajadorService;
import com.joverpenalva.proyectospringboot.models.services.ITrabajoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "api/trabajos", produces = "application/json;charset=UTF-8")
public class TrabajoRestController {
    
    @Autowired
    private ITrabajoService trabajoService;
    private ITrabajadorService trabajadorService;
    
    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }
    
    @GetMapping
    public ResponseEntity<Object> getTrabajos() {
        List<Trabajo> trabajos = trabajoService.findAll();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.OK.value());
        responseBody.put("message", "Success");
        responseBody.put("result", trabajos);
        return ResponseEntity.ok(responseBody);
    }
    
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Trabajo trabajo) {
    	trabajo.setFechaInicio(new Date());
        Trabajo createdTrabajo = trabajoService.save(trabajo);
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.CREATED.value());
        responseBody.put("message", "Trabajo creado exitosamente");
        responseBody.put("result", createdTrabajo);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody Trabajo trabajo) {
        Trabajo existingTrabajo = trabajoService.findById(id);
        if (existingTrabajo == null) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("message", "Trabajo no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }
        trabajo.setCodTrabajo(id);
        Trabajo updatedTrabajo = trabajoService.save(trabajo);
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.OK.value());
        responseBody.put("message", "Trabajo actualizado exitosamente");
        responseBody.put("result", updatedTrabajo);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        Trabajo trabajo = trabajoService.findById(id);
        if (trabajo == null) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("message", "Trabajo no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }
        trabajoService.deleteById(id);
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.OK.value());
        responseBody.put("message", "Trabajo eliminado exitosamente");
        return ResponseEntity.ok(responseBody);
    }
    
    @GetMapping("/pendientes/trabajador")
    public ResponseEntity<Object> getTrabajosPendientes(@RequestParam String idTrabajador, @RequestParam String contraseña) {
        List<Trabajo> trabajosPendientes = trabajoService.findPendientesTrabajador(idTrabajador, contraseña);
        if (trabajosPendientes.isEmpty()) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("message", "No se encontraron trabajos pendientes");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.OK.value());
        responseBody.put("message", "Success");
        responseBody.put("result", trabajosPendientes);
        return ResponseEntity.ok(responseBody);
    }
    
    @GetMapping("/finalizados/trabajador")
    public ResponseEntity<Object> getTrabajosFinalizados(@RequestParam String idTrabajador, @RequestParam String contraseña) {
        List<Trabajo> trabajosFinalizados = trabajoService.findFinalizadosTrabajador(idTrabajador, contraseña);
        if (trabajosFinalizados.isEmpty()) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("message", "No se encontraron trabajos finalizados");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.OK.value());
        responseBody.put("message", "Success");
        responseBody.put("result", trabajosFinalizados);
        return ResponseEntity.ok(responseBody);
    }
    
    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Object> finalizarTrabajo(@PathVariable String id) {
        Trabajo trabajoFinalizado = trabajoService.finalizarTrabajo(id);
        if (trabajoFinalizado == null) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("message", "Trabajo no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.OK.value());
        responseBody.put("message", "Trabajo finalizado exitosamente");
        responseBody.put("result", trabajoFinalizado);
        return ResponseEntity.ok(responseBody);
    }
    
    @PutMapping("/{idTrabajo}/asignar/{idTrabajador}")
    public ResponseEntity<Object> asignarTrabajo(@PathVariable String idTrabajo, @PathVariable String idTrabajador) {
        int resultado = trabajoService.asignarTrabajo(idTrabajo, idTrabajador);
        
        if (resultado == -1) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("message", "Trabajo o trabajador no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }

        if (resultado == -2) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.BAD_REQUEST.value());
            responseBody.put("message", "La categoría del trabajo y la especialidad del trabajador no coinciden");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }
        
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.OK.value());
        responseBody.put("message", "Trabajo asignado exitosamente");
        return ResponseEntity.ok(responseBody);
    }
    
    @PostMapping("/trabajador/{idTrabajador}/crear-trabajo")
    public ResponseEntity<Object> crearTrabajoConTrabajador(@RequestBody Trabajo trabajo, @PathVariable String idTrabajador) {
        Trabajador trabajador = trabajadorService.findById(idTrabajador);
        if (trabajador == null) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("message", "Trabajador no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        }

        trabajo.setTrabajador(trabajador);

        Trabajo createdTrabajo = trabajoService.save(trabajo);

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.CREATED.value());
        responseBody.put("message", "Trabajo creado exitosamente con trabajador asignado");
        responseBody.put("result", createdTrabajo);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }
    
    @GetMapping("/sin-asignar")
    public ResponseEntity<Object> getTareasSinAsignar() {
        List<Trabajo> tareasSinAsignar = trabajoService.findTareasSinAsignar();
        if (tareasSinAsignar.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron tareas sin asignar.");
        }
        return ResponseEntity.ok(tareasSinAsignar);
    }

}
