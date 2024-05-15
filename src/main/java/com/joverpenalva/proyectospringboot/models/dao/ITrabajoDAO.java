package com.joverpenalva.proyectospringboot.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joverpenalva.proyectospringboot.models.entities.Trabajo;

public interface ITrabajoDAO extends CrudRepository<Trabajo, String> {
	
	@Query("SELECT t FROM Trabajo t WHERE t.idTrabajador = :idTrabajador AND t.contraseña = :contraseña AND t.fechaFin IS NULL")
    List<Trabajo> findPendientesTrabajador(String idTrabajador, String contraseña);
	
	@Query("SELECT t FROM Trabajo t WHERE t.idTrabajador = :idTrabajador AND t.contraseña = :contraseña AND t.fechaFin IS NOT NULL")
    List<Trabajo> findFinalizadosTrabajador(String idTrabajador, String contraseña);

}
