package com.joverpenalva.proyectospringboot.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.joverpenalva.proyectospringboot.models.entities.Trabajador;

public interface ITrabajadorDAO extends CrudRepository<Trabajador, String> {

}
