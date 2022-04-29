package com.idat.AbrilServicioI.servicio;

import java.util.List;

import com.idat.AbrilServicioI.modelo.Productos;

public interface ProductoServicio {

	public void guardarProducto(Productos producto);
	public void editarProducto(Productos producto);
	public void eliminarProducto(Integer id);
	public List<Productos> listarProductos();
	public Productos obtenerProductoId(Integer id);
}
