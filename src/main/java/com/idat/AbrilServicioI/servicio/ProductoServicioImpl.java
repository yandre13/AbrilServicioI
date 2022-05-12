package com.idat.AbrilServicioI.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AbrilServicioI.dto.ProductoDTORequest;
import com.idat.AbrilServicioI.dto.ProductoDTOResponse;
import com.idat.AbrilServicioI.modelo.Productos;
import com.idat.AbrilServicioI.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio {
	
	@Autowired
	public ProductoRepositorio repositorio;

	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		Productos p = new Productos();
		p.setIdProducto(producto.getIdProductoDTO());
		p.setNombreProducto(producto.getNombreProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		
		repositorio.save(p);
	}

	@Override
	public void editarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		Productos p = new Productos();
		p.setIdProducto(producto.getIdProductoDTO());
		p.setNombreProducto(producto.getNombreProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		
		repositorio.saveAndFlush(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		// TODO Auto-generated method stub
		List<ProductoDTOResponse> response = new ArrayList<ProductoDTOResponse>();
		List<Productos> productos = repositorio.findAll();
		
		productos.stream().forEach(p -> {
			ProductoDTOResponse pDTO = new ProductoDTOResponse();
			pDTO.setIdProductoDTO(p.getIdProducto());
			pDTO.setNombreProductoDTO(p.getNombreProducto());
			pDTO.setDescripcionDTO(p.getDescripcion());
			pDTO.setPrecioDTO(p.getPrecio());
			pDTO.setStockDTO(p.getStock());
			
			response.add(pDTO);
		});
		return response;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		// TODO Auto-generated method stub
		Productos producto = repositorio.findById(id).orElse(null);
		
		ProductoDTOResponse p = new ProductoDTOResponse();
		p.setIdProductoDTO(producto.getIdProducto());
		p.setNombreProductoDTO(producto.getNombreProducto());
		p.setDescripcionDTO(producto.getDescripcion());
		p.setPrecioDTO(producto.getPrecio());
		p.setStockDTO(producto.getStock());
		return p;
	}

}
