package com.example.demo.models.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
	private int timer; 

    @NotNull
    private String rut;
    
    @NotNull
    //@Column(unique = true)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;
    
    @NotNull
    private String tipo;
    
    private String estado;
    
    private String nombre_segundo;
    
    private String apellido_segundo;
    
    private Date fecha_nacimento;
    
    private String estado_civil;
    
    private String direccion;
    
    private String afp;


    
    private String fecha_in;

    private String tipo_contrato;
    
    private String color;
    
	private Long imposiciones;
    
    
    private String foto;
    @NotNull
    @ManyToMany
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(@NotNull String nombre,
    		@NotNull String nombreUsuario,
    		@NotNull String email,
    		@NotNull String password,
    		@NotNull String apellido,
			@NotNull int timer,
    		@NotNull String rut,
    		@NotNull String apellido_segundo,
    		@NotNull Date fecha_nacimento,
    		@NotNull String estado_civil,
    		@NotNull String direccion ,
    		@NotNull String afp,
    		@NotNull String nombre_segundo,
    		@NotNull String tipo,
    		@NotNull String tipo_contrato,
    		@NotNull String fecha_in,
			@NotNull Long imposiciones
			) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.apellido = apellido;
		this.timer = timer;
        this.rut = rut;
        this.apellido_segundo=apellido_segundo;
        this.fecha_nacimento=fecha_nacimento;
        this.estado_civil=estado_civil;
        this.direccion=direccion;
        this.afp=afp;
        this.nombre_segundo=nombre_segundo;
        this.tipo = tipo;
        this.tipo_contrato = tipo_contrato;

        this.fecha_in=fecha_in;
		this.imposiciones = imposiciones;
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

	
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
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

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    
    public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha_in() {
		return fecha_in;
	}

	public void setFecha_in(String fecha_in) {
		this.fecha_in = fecha_in;
	}

	public String getTipo_contrato() {
		return tipo_contrato;
	}

	public void setTipo_contrato(String tipo_contrato) {
		this.tipo_contrato = tipo_contrato;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getImposiciones() {
		return imposiciones;
	}

	public void setImposiciones(Long imposiciones) {
		this.imposiciones = imposiciones;
	}

	
    
}
