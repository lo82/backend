package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IControlDao;
import com.example.demo.models.entity.Control;

@Service
public class ControlServiceImpl implements IControlService{

	@Autowired
	private IControlDao controlDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Control> findAll() {
		return (List<Control>) controlDao.findAll();
	}

	@Override
	public Control findById(Long id) {
		return controlDao.findById(id).orElse(null);
	}

	@Override
	public Control save(Control control) {
		return controlDao.save(control);
	}

	@Override
	public void delete(Long id) {
		controlDao.deleteById(id);
	}
}
