package com.joverpenalva.proyectospringboot.models.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.joverpenalva.proyectospringboot.models.entities.Trabajo;

public interface ITrabajoDAO extends CrudRepository<Trabajo, String> {
	
	@Query("SELECT t FROM Trabajo t JOIN FETCH t.trabajador tr WHERE tr.idTrabajador = :idTrabajador AND tr.contraseña = :contraseña AND t.fechaFin IS NULL")
	List<Trabajo> findPendientesTrabajador(String idTrabajador, String contraseña);
	
	@Query("SELECT t FROM Trabajo t JOIN FETCH t.trabajador tr WHERE tr.idTrabajador = :idTrabajador AND tr.contraseña = :contraseña AND t.fechaFin IS NOT NULL")
    List<Trabajo> findFinalizadosTrabajador(String idTrabajador, String contraseña);

	@Query("SELECT t FROM Trabajo t LEFT JOIN FETCH t.trabajador WHERE t.trabajador IS NULL")
	List<Trabajo> findTareasSinAsignar();
	
	@Query("SELECT t FROM Trabajo t LEFT JOIN FETCH t.trabajador WHERE t.trabajador IS NOT NULL")
	List<Trabajo> findTareasAsignadas();
	
	@Query("SELECT t FROM Trabajo t WHERE t.fechaFin IS NULL")
	List<Trabajo> findByFechaFinIsNull();
	
	@Query("SELECT t FROM Trabajo t WHERE t.fechaFin IS NOT NULL")
    List<Trabajo> findTareasRealizadas();
	
	@Query("SELECT t FROM Trabajo t WHERE t.trabajador.idTrabajador = :idTrabajador AND t.fechaFin BETWEEN :startDate AND :endDate")
    List<Trabajo> findTareasByTrabajadorAndFecha(@Param("idTrabajador") String idTrabajador, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Query("SELECT t FROM Trabajo t JOIN FETCH t.trabajador tr WHERE tr.idTrabajador = :idTrabajador AND tr.contraseña = :contraseña AND t.fechaFin IS NULL ORDER BY t.prioridad ASC")
    List<Trabajo> findTrabajosOrdenadosPorPrioridad(String idTrabajador, String contraseña);

	@Query("SELECT t FROM Trabajo t JOIN FETCH t.trabajador tr WHERE tr.idTrabajador = :idTrabajador AND tr.contraseña = :contraseña AND t.fechaFin IS NULL AND t.prioridad = :prioridad ORDER BY t.prioridad ASC")
    List<Trabajo> findTrabajosPrioridadConcreta(@Param("idTrabajador") String idTrabajador, @Param("contraseña") String contraseña, @Param("prioridad") int prioridad);

}
