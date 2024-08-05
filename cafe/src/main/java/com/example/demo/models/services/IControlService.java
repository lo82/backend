package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Control;


public interface IControlService {

	public List<Control> findAll();
	
	public Control findById(Long id);
	
	public Control save(Control control);
	
	public void delete(Long id);
}
