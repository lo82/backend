package com.example.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Servicios;

public interface IServicioDao extends CrudRepository<Servicios, Long> {

}
