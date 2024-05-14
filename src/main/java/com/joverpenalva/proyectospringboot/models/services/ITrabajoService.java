package com.joverpenalva.proyectospringboot.models.services;

import java.util.List;

import com.joverpenalva.proyectospringboot.models.entities.Trabajo;

public interface ITrabajoService {

	public List<Trabajo> findAll();
}
