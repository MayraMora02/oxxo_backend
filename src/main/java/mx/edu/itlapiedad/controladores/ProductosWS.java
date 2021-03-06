package mx.edu.itlapiedad.controladores;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itlapiedad.models.Productos;
import mx.edu.itlapiedad.services.ProductoServices;

@RestController
@RequestMapping("devops/oxxo")
public class ProductosWS {

	ProductoServices servicio;
	@GetMapping("/productos")
	public ResponseEntity<?> ConsultarProductos() {
		
		List<Productos> resultado= servicio.ConsultarProductos();
	
		return new ResponseEntity<List<Productos>>(resultado,HttpStatus.OK);
	}
	
	//metodos get por id
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id){
		Productos resultado;
		try {
			resultado=servicio.buscar(id);
		} catch (DataAccessException e) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	return new ResponseEntity<Productos>(resultado,HttpStatus.OK);
}
}
