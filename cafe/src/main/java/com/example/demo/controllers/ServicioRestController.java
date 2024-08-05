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

import com.example.demo.models.entity.Servicios;
import com.example.demo.models.services.IServiciosService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ServicioRestController {

	@Autowired
	private IServiciosService servicioService;

	@GetMapping("/servicios")
	public List<Servicios> index() {
		return servicioService.findAll();
	}

	@GetMapping("/servicios/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Servicios servicio = null;
		Map<String, Object> response = new HashMap<>();

		try {
			servicio = servicioService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (servicio == null) {
			response.put("mensaje", "El servicio Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Servicios>(servicio, HttpStatus.OK);

	}

	@PostMapping("/servicios")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Servicios servicio) {

		Servicios servicionew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			servicionew = servicioService.save(servicio);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El servicios ha sido creado con exito!");
		response.put("sala", servicionew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/servicios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Servicios servicio, @PathVariable Long id) {

		Servicios servicioActual = servicioService.findById(id);

		Servicios servicioUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if (servicio == null) {
			response.put("mensaje", "El servcio Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			servicioActual.setNombre_servicio(servicio.getNombre_servicio());
			servicioActual.setTipo_servicio(servicio.getTipo_servicio());
			servicioActual.setDetalle_servicio(servicio.getDetalle_servicio());
			servicioActual.setEstado_Servicio(servicio.getEstado_Servicio());
			servicioActual.setMetodo_pago(servicio.getMetodo_pago());
			servicioActual.setValor(servicio.getValor());
			servicioActual.setIva(servicio.getIva());
			servicioActual.setPieza(servicio.getPieza());
		

			servicioUpdate = servicioService.save(servicioActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El servicio ha sido actualizado con exito!");
		response.put("servicio", servicioUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/servicios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			servicioService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El servicio fue eliminado con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
