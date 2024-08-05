package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Clientes;

public interface ICLienteService {

	public List<Clientes> findAll();
	
	public Clientes findByID(Long id);
	
	public Clientes save(Clientes clientes);
	
	public void delete (Long id);
}
