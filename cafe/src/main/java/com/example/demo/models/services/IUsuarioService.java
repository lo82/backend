package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id );
	
	public Usuario findEntitiesByIds(List<Long> ids);

	public Usuario cambioestado(Long id );
	
	public Usuario save(Usuario usuario);
	
	public Usuario save(List<Long> ids);

	public void delete(Long id);

	public List<Usuario> findByRolId(Long roles_id);
	
	public List<Usuario> findTraeChica(String tipo);

	public void actualizacionMasiva(String ids);

	public List<Usuario> ids(String color,Long id);
}


