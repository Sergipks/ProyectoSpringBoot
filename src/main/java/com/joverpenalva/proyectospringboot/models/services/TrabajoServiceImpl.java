package com.joverpenalva.proyectospringboot.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.joverpenalva.proyectospringboot.models.dao.ITrabajoDAO;
import com.joverpenalva.proyectospringboot.models.entities.Trabajo;

public class TrabajoServiceImpl implements ITrabajoService {

	@Autowired
	private ITrabajoDAO trabajoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Trabajo> findAll(){
		return (List<Trabajo>) trabajoDao.findAll();
	}
}
