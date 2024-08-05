package com.example.demo.models.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IAccionesDao;
import com.example.demo.models.entity.Acciones;
import com.example.demo.models.entity.Usuario;

@Service
public class AccionesServiceImpl implements IAccionesService {
	
	@Autowired
	private IAccionesDao accionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Acciones> findAll() {
		return (List<Acciones>) accionDao.findAll();
	}

	@Override
	public Acciones findById(Long id) {
		return accionDao.findById(id).orElse(null);
	}

	@Override
	public Acciones save(Acciones accion) {
		return accionDao.save(accion);
	}

	@Override
	public void delete(Long id) {
		accionDao.deleteById(id);
	}
	
	@Override
	public List<Acciones> chicaportrago(long id) {
		return accionDao.chicaportrago(id);
		
		
}
	@Override
	public List<Acciones> chicaporfecha(String nombre , Date fecha) {
		return accionDao.chicaporfecha(nombre,fecha);
	}
	
	@Override
	public List<Acciones> fechainformes(String fecha1 , String fecha2) {
		return accionDao.fechainformes(fecha1,fecha2);
	}
	
	@Override
	public List<Object> findia(String fecha) {
		return accionDao.findia(fecha);
	}
	
	public List<Object> cierrecaja(String fecha1 , String fecha2) {
		return accionDao.cierrecaja(fecha1,fecha2);
	}
	
	public List<Object> cierrecajadatos(String fecha1 , String fecha2) {
		return accionDao.cierrecajadatos(fecha1,fecha2);
	}
	
	public List<Object> cierrecajaid(String fecha1 , String fecha2,Long idu) {
		return accionDao.cierrecajaid(fecha1,fecha2,idu);
	}
	
	public List<Object> color(Long idu) {
		return accionDao.color(idu);
	}
	
	@Override
	public List<Acciones> fechainformesid(String fecha1 , String fecha2,Long id) {
		return accionDao.fechainformesid(fecha1,fecha2,id);
	}
	
	public List<Object> pagocliente(Long id) {
		return accionDao.pagocliente(id);
	}
	
	public List<Object> nombreusuarioid(String id) {
		return accionDao.nombreusuarioid(id);
	}
	
	public List<Object> pagoclientependienteypago(Long id) {
		return accionDao.pagoclientependienteypago(id);
	}

	@Override
	public List<Acciones> fechasDiarias(String fecha1, String fecha2) {
		return accionDao.fechasDiarias(fecha1, fecha2);
	}
	
}
