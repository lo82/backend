package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Acciones;
import com.example.demo.models.entity.Clientes;
import com.example.demo.models.services.ICLienteService;

@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class ClientesRestController {
	
	@Autowired
	private ICLienteService clienteservice;
	
	
	@GetMapping("/clientes")
	public List<Clientes> index(){
		return clienteservice.findAll();
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?>show(@PathVariable Long id){
	
		Clientes clientes = null;
		Map<String, Object> response = new HashMap<>();

		try {
			clientes = clienteservice.findByID(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (clientes == null) {
			response.put("mensaje", "El cliente Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Clientes>(clientes, HttpStatus.OK);

	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Clientes clientes) {

		Clientes clientesnew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			clientesnew = clienteservice.save(clientes);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido creado con exito!");
		response.put("clientes", clientesnew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Clientes cliente, @PathVariable Long id) {

		Clientes clienteActual = clienteservice.findByID(id);

		Clientes clientesUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if (cliente == null) {
			response.put("mensaje", "El cliente Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			
			clienteActual.setEstado(cliente.getEstado());
			clientesUpdate = clienteservice.save(clientesUpdate);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido actualizado con exito!");
		response.put("clientes", clientesUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	Map<String, Object> response = new HashMap<>();
	try {
		clienteservice.delete(id);
	} catch (DataAccessException e) {
		response.put("mensaje", "Error al eliminar en la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	response.put("mensaje", "El cliente fue eliminado con exito!");

	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
}
	
}
