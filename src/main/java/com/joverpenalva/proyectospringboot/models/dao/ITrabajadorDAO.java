package com.joverpenalva.proyectospringboot.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joverpenalva.proyectospringboot.models.entities.Trabajador;

public interface ITrabajadorDAO extends CrudRepository<Trabajador, String> {
	@Query("SELECT t FROM Trabajador t WHERE t.especialidad LIKE :especialidad")
	List<Trabajador> findByEspecialidad(String especialidad);
}
