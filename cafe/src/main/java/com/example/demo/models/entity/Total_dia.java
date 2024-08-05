package com.example.demo.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "total_dia")
public class Total_dia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fechadia;
	
	private int ingreso_caja;

	private int total;
	
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechadia() {
		return fechadia;
	}

	public int getIngreso_caja() {
		return ingreso_caja;
	}

	public void setIngreso_caja(int ingreso_caja) {
		this.ingreso_caja = ingreso_caja;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setFechadia(String fecha_dia) {
		this.fechadia = fecha_dia;
	}

	public int getTotal() {
		return total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	private static final long serialVersionUID = 1L;

}
