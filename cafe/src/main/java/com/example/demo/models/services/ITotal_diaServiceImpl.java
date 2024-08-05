package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Total_dia;

public interface ITotal_diaServiceImpl {
	
	public List<Total_dia> findAll();
	
	public Total_dia findById(Long id);
	
	public Total_dia save(Total_dia total_dia);
	
	public void delete(Long id);
	
	public List<Object> bcaja(String fecha);

}
