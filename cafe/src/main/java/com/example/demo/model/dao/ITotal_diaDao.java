package com.example.demo.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Total_dia;

public interface ITotal_diaDao extends CrudRepository<Total_dia, Long> {
	
	@Modifying
	@Query(value=  "select td.ingreso_caja from Total_dia td where fechadia=?1",nativeQuery = true  )
	public List<Object> bcaja(String fd);

}
