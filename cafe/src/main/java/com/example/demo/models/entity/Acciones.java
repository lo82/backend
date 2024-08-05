package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "acciones")
public class Acciones implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private boolean checked=false;

	private String fecha_dia;

	private Date fecha_trago;

	private int total_ganado;

	private String tipo_accion;

	private String estado_de_pago;

	private String estado;

	private int adelanto;

	private int comisiones;

	private String pendiente;
	
	private String bonificacion;

	private String dia_activo;

	private int caja;
	
	private String tipo_pago;

	private int cantidad;

	private int propina;
	
	private String pieza;

	private int iva;



	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Servicios servicio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Clientes cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Tragos tragos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Garzon garzon;


	public String getDia_activo() {
		return dia_activo;
	}

	public void setDia_activo(String dia_activo) {
		this.dia_activo = dia_activo;
	}

	public long getId() {
		return id;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFecha_dia() {
		return fecha_dia;
	}

	public void setFecha_dia(String fecha_dia) {
		this.fecha_dia = fecha_dia;
	}

	public int getTotal_ganado() {
		return total_ganado;
	}

	public void setTotal_ganado(int total_ganado) {
		this.total_ganado = total_ganado;
	}

	public String getTipo_accion() {
		return tipo_accion;
	}

	public void setTipo_accion(String tipo_accion) {
		this.tipo_accion = tipo_accion;
	}

	public String getEstado_de_pago() {
		return estado_de_pago;
	}

	public void setEstado_de_pago(String estado_de_pago) {
		this.estado_de_pago = estado_de_pago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getAdelanto() {
		return adelanto;
	}

	public void setAdelanto(int adelanto) {
		this.adelanto = adelanto;
	}

	public int getComisiones() {
		return comisiones;
	}

	public void setComisiones(int comisiones) {
		this.comisiones = comisiones;
	}

	public String getPendiente() {
		return pendiente;
	}

	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}

	public Servicios getServicio() {
		return servicio;
	}

	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tragos getTragos() {
		return tragos;
	}

	public void setTragos(Tragos tragos) {
		this.tragos = tragos;
	}
	

	public Date getFecha_trago() {
		return fecha_trago;
	}

	public void setFecha_trago(Date fecha_trago) {
		this.fecha_trago = fecha_trago;
	}

	public int getCaja() {
		return caja;
	}

	public void setCaja(int caja) {
		this.caja = caja;
	}




	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public String getTipo_pago() {
		return tipo_pago;
	}

	public void setTipo_pago(String tipo_pago) {
		this.tipo_pago = tipo_pago;
	}
	
	

	public String getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(String bonificacion) {
		this.bonificacion = bonificacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private static final long serialVersionUID = 1L;

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPropina() {
		return propina;
	}

	public void setPropina(int propina) {
		this.propina = propina;
	}

	public String getPieza() {
		return pieza;
	}

	public void setPieza(String pieza) {
		this.pieza = pieza;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public Garzon getGarzon() {
		return garzon;
	}

	public void setGarzon(Garzon garzon) {
		this.garzon = garzon;
	}

	

}
