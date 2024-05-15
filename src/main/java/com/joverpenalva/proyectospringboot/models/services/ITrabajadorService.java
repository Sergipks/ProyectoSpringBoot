package com.joverpenalva.proyectospringboot.models.services;

import java.util.List;

import com.joverpenalva.proyectospringboot.models.entities.Trabajador;

public interface ITrabajadorService {

	public List<Trabajador> findAll();
	public Trabajador save(Trabajador trabajo);
	public void deleteById(String id);
	public Trabajador findById(String id);
}
