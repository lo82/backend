package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Horarios;

public interface IHorarioService {
	
	public List<Horarios> findAll();
	
	public Horarios findById(Long id);
	
	public Horarios save(Horarios horario);
	
	public void delete(Long id);

}
