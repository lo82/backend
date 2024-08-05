package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horarios implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String horario_entrada;

	private String horario_salida;

	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHorario_entrada() {
		return horario_entrada;
	}

	public void setHorario_entrada(String horario_entrada) {
		this.horario_entrada = horario_entrada;
	}

	public String getHorario_salida() {
		return horario_salida;
	}

	public void setHorario_salida(String horario_salida) {
		this.horario_salida = horario_salida;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private static final long serialVersionUID = 1L;
}
