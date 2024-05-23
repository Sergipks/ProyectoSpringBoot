package com.joverpenalva.proyectospringboot.models.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joverpenalva.proyectospringboot.models.entities.Trabajador;
import com.joverpenalva.proyectospringboot.models.dao.ITrabajadorDAO;
import com.joverpenalva.proyectospringboot.models.dao.ITrabajoDAO;
import com.joverpenalva.proyectospringboot.models.entities.Trabajo;

@Service
public class TrabajoServiceImpl implements ITrabajoService {

	@Autowired
	private ITrabajoDAO trabajoDao;
	
	@Autowired
	private ITrabajadorDAO trabajadorDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Trabajo> findAll(){
		return (List<Trabajo>) trabajoDao.findAll();
	}
	
	@Override
    @Transactional
    public Trabajo save(Trabajo trabajo) {
        return trabajoDao.save(trabajo);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        trabajoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Trabajo findById(String id) {
        return trabajoDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Trabajo> findPendientesTrabajador(String idTrabajador, String contraseña) {
        return trabajoDao.findPendientesTrabajador(idTrabajador, contraseña);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Trabajo> findFinalizadosTrabajador(String idTrabajador, String contraseña) {
        return trabajoDao.findFinalizadosTrabajador(idTrabajador, contraseña);
    }
    
    @Override
    @Transactional
    public Trabajo finalizarTrabajo(String id) {
        Trabajo trabajo = trabajoDao.findById(id).orElse(null);
        if (trabajo != null) {
            trabajo.setFechaFin(new Date());
            return trabajoDao.save(trabajo);
        }
        return null;
    }
    
    @Override
    @Transactional
    public int asignarTrabajo(String idTrabajo, String idTrabajador) {
    	Trabajo trabajo = trabajoDao.findById(idTrabajo).orElse(null);
        Trabajador trabajador = trabajadorDao.findById(idTrabajador).orElse(null);

        if (trabajo == null || trabajador == null) {
            return -1;
        }

        if (!trabajo.getCategoria().equals(trabajador.getEspecialidad())) {
            return -2;
        }

        trabajo.setIdTrabajador(idTrabajador);
        trabajoDao.save(trabajo);
        
        return 1;
    }
    
    @Override
    @Transactional
    public List<Trabajo> findTareasSinAsignar() {
        return trabajoDao.findTareasSinAsignar();
    }
    
    @Override
    @Transactional
    public List<Trabajo> findTareasSinFinalizar() {
        return trabajoDao.findByFechaFinIsNull();
    }
    
    @Override
    @Transactional
    public List<Trabajo> findTareasRealizadas() {
        return trabajoDao.findTareasRealizadas();
    }
    
    @Override
    @Transactional
    public List<Trabajo> findTareasByTrabajadorAndFecha(String idTrabajador, Date startDate, Date endDate) {
        return trabajoDao.findTareasByTrabajadorAndFecha(idTrabajador, startDate, endDate);
    }
}
