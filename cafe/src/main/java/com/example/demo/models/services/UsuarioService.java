package com.example.demo.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.InvalidFieldException;
import com.example.demo.model.dao.IUsuarioDao;
import com.example.demo.model.dao.UsuarioRepository;
import com.example.demo.models.entity.Usuario;

@Service
@Transactional
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
    
	@Autowired
	private IUsuarioDao usuarioDao;
    
	@Override
	//@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

    public Optional<Usuario> getByNombreUsuario(String nu){
        return usuarioRepository.findByNombreUsuario(nu);
    }

    public boolean existePorNombre(String nu){
        return usuarioRepository.existsByNombreUsuario(nu);
    }

    public  boolean existePorEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void guardar(Usuario usuario){
        usuarioRepository.save(usuario);
    }

	public Usuario findEntitiesByIds(List<Long> ids) {
        return (Usuario) usuarioRepository.findAllById(ids);
    }

	@Override
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}
	
	public void updateEntity(Usuario usuario) {
        // Aquí podrías tener la lógica necesaria para validar y actualizar la entidad en la base de datos
        usuarioRepository.save(usuario);
    }

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	public void delete(Long id) {
		usuarioDao.deleteById(id);
	}

	@Override
	public List<Usuario> findByRolId(Long roles_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Usuario> findTraeChica(String tipo) {
		return usuarioDao.findTraeChica(tipo);
	}

	@Override
	public Usuario cambioestado(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario save(List<Long> ids) {
		return (Usuario) usuarioRepository.findAllById(ids);
	}

	@Override
	public void actualizacionMasiva(String ids) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actualizacionMasiva'");
	}



	
	public List<Usuario> ids(String color,Long id) {
		return usuarioDao.ids(color,id);
	}

	
    
}