package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IClientesDao;
import com.example.demo.model.dao.IGarzonDao;
import com.example.demo.models.entity.Clientes;
import com.example.demo.models.entity.Garzon;

@Service
public class GarzonServiceImpl implements IGarzonService {

	@Autowired
	private IGarzonDao garzonDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Garzon> findAll() {
		return (List<Garzon>) garzonDao.findAll();
	}

	@Override
	public Garzon findByID(Long id) {
		// TODO Auto-generated method stub
		return garzonDao.findById(id).orElse(null);
	}
	
	@Override
	public Garzon save(Garzon garzon) {
		return garzonDao.save(garzon);
		
	}

	@Override
	public void delete(Long id) {
		garzonDao.deleteById(id);
		
	}

    
}
