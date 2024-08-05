package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Garzon;


public interface IGarzonService {

  
	public List<Garzon> findAll();
	
	public Garzon findByID(Long id);
	
	public Garzon save(Garzon garzon);
	
	public void delete (Long id);  

    
}
