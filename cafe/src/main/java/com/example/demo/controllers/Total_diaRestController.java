package com.example.demo.controllers;

import java.text.ParseException;
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

import com.example.demo.models.entity.Horarios;
import com.example.demo.models.entity.Total_dia;
import com.example.demo.models.entity.Tragos;
import com.example.demo.models.services.ITotal_diaServiceImpl;

@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class Total_diaRestController {
	
	@Autowired
	private ITotal_diaServiceImpl totaldiaser;
	
	@GetMapping("/totaldia")
	public List<Total_dia> index(){
		return totaldiaser.findAll();
	}

	@GetMapping("totaldia/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Total_dia totaldia = null;
		Map<String, Object> response = new HashMap<>();

		try {
			totaldia = totaldiaser.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (totaldia == null) {
			response.put("mensaje", "El horario Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Total_dia>(totaldia, HttpStatus.OK);

	}
	
	@PostMapping("/totaldia")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Total_dia totaldia){
		System.out.println(totaldia);
		Total_dia totaldianew =null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			totaldianew = totaldiaser.save(totaldia);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El dia ha sido creado con exito!");
		response.put("trago", totaldianew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/totaldia/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Total_dia totaldia, @PathVariable Long id ){
	
		Total_dia totaldiaActual =totaldiaser.findById(id);
		System.out.println(totaldia);
		Total_dia totaldiaUpdate =null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (totaldia == null) {
			response.put("mensaje", "El dia Id:" .concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		try {
			totaldiaActual.setIngreso_caja(totaldia.getIngreso_caja());
			totaldiaActual.setTotal(totaldia.getTotal());
			totaldiaActual.setEstado(totaldia.getEstado());
			
			totaldiaUpdate = totaldiaser.save(totaldiaActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		response.put("mensaje", "El dia ha sido actualizado con exito!");
		response.put("trago", totaldiaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/bcaja/{fd}")
	public ResponseEntity<?> bcaja(@PathVariable String fd) throws ParseException {
		
		Map<String, Object> response = new HashMap<>();
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		//Date date = simpleDateFormat.parse(fd);
		System.out.println(fd);
		List<Object> cajadia = null;

		try {
			cajadia = totaldiaser.bcaja(fd);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al ejecutar procedimiento almacenado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity <List<Object>>(cajadia, HttpStatus.OK);
	}
}
