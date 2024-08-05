package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dao.IServicioDao;
import com.example.demo.models.entity.Servicios;

@Service
public class ServiciosServiceImpl implements IServiciosService{

	@Autowired
	private IServicioDao servicioDao;
	
	@Override
	public List<Servicios> findAll() {
		return (List<Servicios>) servicioDao.findAll();
	}

	@Override
	public Servicios findById(Long id) {
		return servicioDao.findById(id).orElse(null);
	}

	@Override
	public Servicios save(Servicios servicio) {
		return servicioDao.save(servicio);
	}

	@Override
	public void delete(Long id) {
		servicioDao.deleteById(id);
		
	}

}
