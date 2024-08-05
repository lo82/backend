package com.example.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Horarios;

public interface IHorarioDao extends CrudRepository<Horarios, Long> {

}
