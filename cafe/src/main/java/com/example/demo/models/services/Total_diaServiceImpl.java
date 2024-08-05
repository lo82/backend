package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.ITotal_diaDao;
import com.example.demo.models.entity.Horarios;
import com.example.demo.models.entity.Total_dia;

@Service
public class Total_diaServiceImpl implements ITotal_diaServiceImpl {

	@Autowired
	private ITotal_diaDao totaldia;
	
	@Override
	@Transactional(readOnly = true)
	public List<Total_dia> findAll() {
		return (List<Total_dia>) totaldia.findAll();
	}

	@Override
	public Total_dia findById(Long id) {
		// TODO Auto-generated method stub
		return totaldia.findById(id).orElse(null);
	}

	@Override
	public Total_dia save(Total_dia total_dia) {
		return totaldia.save(total_dia);
	}

	@Override
	public void delete(Long id) {
		totaldia.deleteById(id);
		
	}
	
	@Override
	public List<Object> bcaja(String fecha) {
		return totaldia.bcaja(fecha);
	}

}
