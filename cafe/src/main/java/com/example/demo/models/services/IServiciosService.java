package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Servicios;

public interface IServiciosService {
	
	public List<Servicios> findAll();
	
	public Servicios findById(Long id);
	
	public Servicios save(Servicios servicio);
	
	public void delete (Long id);

}
