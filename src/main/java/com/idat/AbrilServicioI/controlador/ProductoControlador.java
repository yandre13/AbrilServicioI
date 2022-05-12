package com.idat.AbrilServicioI.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.AbrilServicioI.dto.ProductoDTORequest;
import com.idat.AbrilServicioI.dto.ProductoDTOResponse;
import com.idat.AbrilServicioI.modelo.Productos;
import com.idat.AbrilServicioI.servicio.ProductoServicio;

@RestController
@RequestMapping("/producto/v1")
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProductoDTOResponse>> listarProductos(){
		return new ResponseEntity<List<ProductoDTOResponse>>(servicio.listarProductos(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductoDTORequest producto){
		servicio.guardarProducto(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductoDTOResponse> listarPorId(@PathVariable Integer id){
		ProductoDTOResponse p = servicio.obtenerProductoId(id);
		if(p != null)
			return new ResponseEntity<ProductoDTOResponse>(p, HttpStatus.OK);
		return new ResponseEntity<ProductoDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ProductoDTORequest producto){
		ProductoDTOResponse p = servicio.obtenerProductoId(producto.getIdProductoDTO());
		if(p != null) {
			servicio.editarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ProductoDTOResponse p = servicio.obtenerProductoId(id);
		if(p != null) {
			servicio.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
