package com.joverpenalva.proyectospringboot.models.services;

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
}
