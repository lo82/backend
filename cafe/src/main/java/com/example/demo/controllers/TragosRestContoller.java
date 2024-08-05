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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Tragos;
import com.example.demo.models.services.ITragosService;

@CrossOrigin(origins ={"http://loalhost:4200","*"})
@RestController
@RequestMapping("/api")
public class TragosRestContoller {
	
	@Autowired
	private ITragosService tragosService;
	
	@GetMapping("/tragos")
	public List<Tragos>index(){
		return tragosService.findAll();
	}
	
	@GetMapping("/tragos{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Tragos trago = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			trago = tragosService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (trago == null) {
			response.put("mensaje", "El tipo id:".concat(id.toString().concat(" no existe en la base de datos!")));
		}
		return new ResponseEntity<Tragos>(trago, HttpStatus.OK);
	}
	
	@PostMapping("/tragos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Tragos trago){
	
		Tragos tragonew =null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			tragonew = tragosService.save(trago);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El trago ha sido creado con exito!");
		response.put("trago", tragonew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/tragos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Tragos trago, @PathVariable Long id ){
	
		Tragos tragoActual =tragosService.findById(id);
		
		Tragos tragoUpdate =null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (trago == null) {
			response.put("mensaje", "El tipo Id:" .concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		try {
			tragoActual.setNombre_trago(trago.getNombre_trago());
			tragoActual.setTipo_trago(trago.getTipo_trago());
			tragoActual.setEstado_trago(trago.getEstado_trago());
			tragoActual.setValor_trago(trago.getValor_trago());
			tragoActual.setIva(trago.getIva());
			tragoActual.setMetodo_pago(trago.getMetodo_pago());
			
			tragoUpdate = tragosService.save(tragoActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		response.put("mensaje", "El trago ha sido actualizado con exito!");
		response.put("trago", tragoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/tragos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			tragosService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El trago eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
