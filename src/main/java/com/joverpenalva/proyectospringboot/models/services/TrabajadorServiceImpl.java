package com.joverpenalva.proyectospringboot.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joverpenalva.proyectospringboot.models.dao.ITrabajadorDAO;
import com.joverpenalva.proyectospringboot.models.entities.Trabajador;

@Service
public class TrabajadorServiceImpl implements ITrabajadorService {

	@Autowired
	private ITrabajadorDAO trabajadorDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Trabajador> findAll(){
		return (List<Trabajador>) trabajadorDao.findAll();
	}
	
	@Override
    @Transactional
    public Trabajador save(Trabajador trabajador) {
        return trabajadorDao.save(trabajador);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        trabajadorDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Trabajador findById(String id) {
        return trabajadorDao.findById(id).orElse(null);
    }
    
    @Override
    public List<Trabajador> findByEspecialidad(String especialidad) {
        return trabajadorDao.findByEspecialidad(especialidad);
    }
}
