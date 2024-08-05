package com.example.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Clientes;

public interface IClientesDao extends CrudRepository<Clientes, Long> {

}
