package com.joverpenalva.proyectospringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joverpenalva.proyectospringboot.models.entities.Trabajador;
import com.joverpenalva.proyectospringboot.models.services.ITrabajadorService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/trabajadores")
public class TrabajadorRestController {
	
	@Autowired
	private ITrabajadorService trabajadorService;
	
	@GetMapping
	public List<Trabajador> index(){
		return trabajadorService.findAll();
	}
	
}
