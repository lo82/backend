package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IClientesDao;
import com.example.demo.models.entity.Clientes;

@Service
public class ClientesServiceImpl implements ICLienteService {

	@Autowired
	private IClientesDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Clientes> findAll() {
		return (List<Clientes>) clienteDao.findAll();
	}

	@Override
	public Clientes findByID(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}
	
	@Override
	public Clientes save(Clientes clientes) {
		return clienteDao.save(clientes);
		
	}

	@Override
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}

}
