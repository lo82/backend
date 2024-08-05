package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Control;
import com.example.demo.models.entity.Garzon;
import com.example.demo.models.services.IControlService;
import com.example.demo.models.services.IGarzonService;

@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class GarzonesRestController {
    
    @Autowired
	private IGarzonService garzonService;
	
    @GetMapping("/garzon")
	public List<Garzon> index() {
		return garzonService.findAll();
	}

    @GetMapping("/garzon/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Garzon garzon = null;
		Map<String, Object> response = new HashMap<>();

		try {
			garzon = garzonService.findByID(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (garzon == null) {
			response.put("mensaje", "El garzon Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Garzon>(garzon, HttpStatus.OK);

	}

	@PostMapping("/garzon")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Garzon garzon) {

		Garzon garzonnew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			garzonnew = garzonService.save(garzon);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El garzón ha sido creado con exito!");
		response.put("sala", garzonnew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}


}
