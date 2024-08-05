package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dao.IHorarioDao;
import com.example.demo.models.entity.Horarios;

@Service
public class HorarioServiceImpl implements IHorarioService {
	
	@Autowired
	private IHorarioDao horarioDao;

	@Override
	public List<Horarios> findAll() {
		return (List<Horarios>) horarioDao.findAll();
	}

	@Override
	public Horarios findById(Long id) {
		return horarioDao.findById(id).orElse(null);
	}

	@Override
	public Horarios save(Horarios horario) {
		return horarioDao.save(horario);
	}

	@Override
	public void delete(Long id) {
		horarioDao.deleteById(id);

	}

}
