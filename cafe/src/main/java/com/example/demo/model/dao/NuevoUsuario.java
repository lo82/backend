package com.example.demo.model.dao;

import java.util.Date;
import java.util.Set;

public class NuevoUsuario {
    
    private String nombre;
    private String email;
    private String apellido;
	private int timer;    
    private String rut;
    private String nombreUsuario;
    private String nombre_segundo;    
    private String apellido_segundo;    
    private Date fecha_nacimento;    
    private String estado_civil;    
    private String direccion;    
    private String afp;
    private String password;
    private Set<String> roles;    
    private String tipo;    
    private String fecha_in;    
    private String Tipo_contrato;
	private Long imposiciones;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha_in() {
		return fecha_in;
	}

	public void setFecha_in(String fecha_in) {
		this.fecha_in = fecha_in;
	}

	public String getNombre_segundo() {
		return nombre_segundo;
	}

	public void setNombre_segundo(String nombre_segundo) {
		this.nombre_segundo = nombre_segundo;
	}

	public String getApellido_segundo() {
		return apellido_segundo;
	}

	public void setApellido_segundo(String apellido_segundo) {
		this.apellido_segundo = apellido_segundo;
	}

	public Date getFecha_nacimento() {
		return fecha_nacimento;
	}

	public void setFecha_nacimento(Date fecha_nacimento) {
		this.fecha_nacimento = fecha_nacimento;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public String getTipo_contrato() {
		return Tipo_contrato;
	}

	public void setTipo_contrato(String tipo_contrato) {
		Tipo_contrato = tipo_contrato;
	}

	public Long getImposiciones() {
		return imposiciones;
	}

	public void setImposiciones(Long imposiciones) {
		this.imposiciones = imposiciones;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	
	
}