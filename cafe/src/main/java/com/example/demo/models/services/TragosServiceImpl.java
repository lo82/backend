package com.example.demo.models.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.ITragosDao;
import com.example.demo.models.entity.Tragos;

@Service
public class TragosServiceImpl implements ITragosService  {
	
	@Autowired
	private ITragosDao tragoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Tragos> findAll() {
		return (List<Tragos>) tragoDao.findAll();
	}

	@Override
	public Tragos findById(Long id) {
		return tragoDao.findById(id).orElse(null);
	}

	@Override
	public Tragos save(Tragos tragos) {
		return tragoDao.save(tragos);
	}

	@Override
	public void delete(Long id) {
		tragoDao.deleteById(id);
	}

}
