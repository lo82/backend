package com.example.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.example.demo.models.services.IAccionesService;



@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class AccionesRestController {
	
	@Autowired
	private IAccionesService accionesService;

	@GetMapping("/acciones")
	public List<Acciones> index() {
		return accionesService.findAll();
	}
	
	@GetMapping("/acciones/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Acciones acciones = null;
		Map<String, Object> response = new HashMap<>();

		try {
			acciones = accionesService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (acciones == null) {
			response.put("mensaje", "La accione Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Acciones>(acciones, HttpStatus.OK);

	}
	
	@PostMapping("/acciones")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Acciones acciones) {

		Acciones accionesnew = null;
		Map<String, Object> response = new HashMap<>();
		System.out.println(acciones);
		try {
			accionesnew = accionesService.save(acciones);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La accione ha sido creado con exito!");
		response.put("acciones", accionesnew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/acciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Acciones acciones, @PathVariable Long id) {

		Acciones accionesActual = accionesService.findById(id);

		Acciones accionesUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if (acciones == null) {
			response.put("mensaje", "La accione Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			accionesActual.setFecha_dia(acciones.getFecha_dia());
			accionesActual.setTotal_ganado(acciones.getTotal_ganado());
			accionesActual.setServicio(acciones.getServicio());
			accionesActual.setTragos(acciones.getTragos());
			accionesActual.setUsuario(acciones.getUsuario());
			accionesActual.setTipo_accion(acciones.getTipo_accion());
			accionesActual.setPendiente(acciones.getPendiente());
			accionesActual.setEstado(acciones.getEstado());
			accionesActual.setAdelanto(acciones.getAdelanto());
			accionesActual.setComisiones(acciones.getComisiones());
			accionesActual.setDia_activo(acciones.getDia_activo());
			accionesActual.setBonificacion(acciones.getBonificacion());
			accionesActual.setCantidad(acciones.getCantidad());
			accionesActual.setPropina(acciones.getPropina());
		

			accionesUpdate = accionesService.save(accionesActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la accion ha sido actualizado con exito!");
		response.put("acciones", accionesUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/acciones/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			accionesService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La accion eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/tragos/{id}")
	public ResponseEntity<?> chicaportrago(@PathVariable Long id) {

		List<Acciones> accion = null;
		Map<String, Object> response = new HashMap<>();

		try {
			accion = accionesService.chicaportrago(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Acciones>>(accion, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/dia/{nombre}/{fecha}")
	public ResponseEntity<?> chicaporfecha(@PathVariable String nombre,@PathVariable String fecha)throws ParseException {

		List<Acciones> accion = null;
		Map<String, Object> response = new HashMap<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = simpleDateFormat.parse(fecha);

		try {
			accion = accionesService.chicaporfecha(nombre,date);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(nombre.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Acciones>>(accion, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/informes/{fecha1}/{fecha2}")
	public ResponseEntity<?> fechainformes(@PathVariable String fecha1,@PathVariable String fecha2)throws ParseException {

		List<Acciones> accion = null;
		Map<String, Object> response = new HashMap<>();
		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = simpleDateFormat.parse(fecha1);
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = simpleDateFormat2.parse(fecha2);
*/      System.out.println(fecha1+" entro");
		System.out.println(fecha2);
		try {
			accion = accionesService.fechainformes(fecha1,fecha2);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(fecha1.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Acciones>>(accion, HttpStatus.OK);
	}
	
	@PutMapping("/accionestado/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updatestado(@RequestBody Acciones acciones, @PathVariable Long id) {

		Acciones accionesActual = accionesService.findById(id);

		Acciones accionesUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if (acciones == null) {
			response.put("mensaje", "La accione Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			accionesActual.setEstado(acciones.getEstado());
			accionesActual.setTipo_pago(acciones.getTipo_pago());
			accionesUpdate = accionesService.save(accionesActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la accion ha sido actualizado con exito!");
		response.put("acciones", accionesUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/acciones/findia/{fd}")
	public ResponseEntity<?> findia(@PathVariable String fd) throws ParseException {
		
		Map<String, Object> response = new HashMap<>();
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		//Date date = simpleDateFormat.parse(fd);
		
		List<Object> reservahora = null;

		try {
			reservahora = accionesService.findia(fd);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al ejecutar procedimiento almacenado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity <List<Object>>(reservahora, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/cierrecaja/{fecha1}/{fecha2}")
	public ResponseEntity<?> cierrecaja(@PathVariable String fecha1,@PathVariable String fecha2)throws ParseException {

		List<Object> accion = null;
		Map<String, Object> response = new HashMap<>();

		try {
			accion = accionesService.cierrecaja(fecha1,fecha1);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(fecha1.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(accion, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/cierrecajadatos/{fecha1}/{fecha2}")
	public ResponseEntity<?> cierrecajadatos(@PathVariable String fecha1,@PathVariable String fecha2)throws ParseException {

		List<Object> accion = null;
		Map<String, Object> response = new HashMap<>();

		try {
			accion = accionesService.cierrecajadatos(fecha1,fecha1);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(fecha1.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(accion, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/cierrecaja/id/{fecha1}/{fecha2}/{id}")
	public ResponseEntity<?> cierrecajaid(@PathVariable String fecha1,@PathVariable String fecha2,@PathVariable Long id)throws ParseException {

		List<Object> accion = null;
		Map<String, Object> response = new HashMap<>();

		try {
			accion = accionesService.cierrecajaid(fecha1,fecha1,id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(fecha1.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(accion, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/color/{id}")
	public ResponseEntity<?> color(@PathVariable Long id)throws ParseException {

		List<Object> accion = null;
		Map<String, Object> response = new HashMap<>();

		try {
			accion = accionesService.color(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".toString().concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(accion, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/informes/id/{fecha1}/{fecha2}/{id}")
	public ResponseEntity<?> fechainformesid(@PathVariable String fecha1,@PathVariable String fecha2,@PathVariable Long id)throws ParseException {

		List<Acciones> accion = null;
		Map<String, Object> response = new HashMap<>();
		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = simpleDateFormat.parse(fecha1);
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = simpleDateFormat2.parse(fecha2);
*/      System.out.println(fecha1+" entro");
		System.out.println(fecha2);
		try {
			accion = accionesService.fechainformesid(fecha1,fecha2,id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(fecha1.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Acciones>>(accion, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/pagocliente/{id}")
	public ResponseEntity<?> pagocliente(@PathVariable Long id)throws ParseException {

		List<Object> accion = null;
		Map<String, Object> response = new HashMap<>();
			System.out.println(id);
		try {
			accion = accionesService.pagocliente(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(accion, HttpStatus.OK);
	}
	
	@GetMapping("/nombreusuarioid/{user}")
	public ResponseEntity<?> nombreusuarioid(@PathVariable String user)throws ParseException {

		List<Object> accion = null;
		Map<String, Object> response = new HashMap<>();
			System.out.println(user);
		try {
			accion = accionesService.nombreusuarioid(user);
			System.out.println(user);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(user.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(accion, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/pagoclientepyp/{id}")
	public ResponseEntity<?> pagoclientependienteypago(@PathVariable Long id)throws ParseException {

		List<Object> accion = null;
		Map<String, Object> response = new HashMap<>();
			System.out.println(id);
		try {
			accion = accionesService.pagoclientependienteypago(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(accion, HttpStatus.OK);
	}

	@GetMapping("/acciones/informeDiario/{fecha1}/{fecha2}")
	public ResponseEntity<?> fechaDiarias(@PathVariable String fecha1,@PathVariable String fecha2)throws ParseException {

		List<Acciones> accion = null;
		Map<String, Object> response = new HashMap<>();
		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = simpleDateFormat.parse(fecha1);
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date2 = simpleDateFormat2.parse(fecha2);
*/      System.out.println(fecha1+" entro");
		System.out.println(fecha2);
		try {
			accion = accionesService.fechasDiarias(fecha1,fecha2);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(fecha1.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Acciones>>(accion, HttpStatus.OK);
	}
	


}
