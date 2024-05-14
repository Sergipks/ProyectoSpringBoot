package com.joverpenalva.proyectospringboot.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.joverpenalva.proyectospringboot.models.entities.Trabajo;

public interface ITrabajoDAO extends CrudRepository<Trabajo, String> {

}
