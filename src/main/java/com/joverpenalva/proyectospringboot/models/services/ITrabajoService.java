package com.joverpenalva.proyectospringboot.models.services;

import java.util.Date;
import java.util.List;

import com.joverpenalva.proyectospringboot.models.entities.Trabajo;

public interface ITrabajoService {

	public List<Trabajo> findAll();
	public Trabajo save(Trabajo trabajo);
	public void deleteById(String id);
	public Trabajo findById(String id);
	public List<Trabajo> findPendientesTrabajador(String idTrabajador, String contraseña);
	public List<Trabajo> findFinalizadosTrabajador(String idTrabajador, String contraseña);
	public Trabajo finalizarTrabajo(String id);
	public int asignarTrabajo(String idTrabajo, String idTrabajador);
	
	
    public List<Trabajo> findTareasSinAsignar();
    public List<Trabajo> findTareasAsignadas();
    public List<Trabajo> findTareasSinFinalizar();
    public List<Trabajo> findTareasRealizadas();
    public List<Trabajo> findTareasByTrabajadorAndFecha(String idTrabajador, Date startDate, Date endDate);
	public List<Trabajo> findTrabajosOrdenadosPorPrioridad(String idTrabajador, String contraseña);
    public List<Trabajo> findTrabajosPrioridadConcreta(String idTrabajador, String contraseña, int prioridad);

}
