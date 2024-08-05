package com.example.demo.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	/*Query para traer a la chica con tipo usuario*/
	@Query("select usu from Usuario usu where usu.tipo=?1")
	public List<Usuario> findTraeChica(String tipo);

	@Query("update Usuario set usuario_color=?1 where usuario_id=?2")
	public List<Usuario> ids(String color, Long id);

}

