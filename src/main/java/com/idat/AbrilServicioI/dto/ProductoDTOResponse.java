package com.idat.AbrilServicioI.dto;

public class ProductoDTOResponse {

	private Integer idProductoDTO;
	private String nombreProductoDTO;
	private String descripcionDTO;
	private Double precioDTO;
	private Integer stockDTO;
	public Integer getIdProductoDTO() {
		return idProductoDTO;
	}
	public void setIdProductoDTO(Integer idProductoDTO) {
		this.idProductoDTO = idProductoDTO;
	}
	public String getNombreProductoDTO() {
		return nombreProductoDTO;
	}
	public void setNombreProductoDTO(String nombreProductoDTO) {
		this.nombreProductoDTO = nombreProductoDTO;
	}
	public String getDescripcionDTO() {
		return descripcionDTO;
	}
	public void setDescripcionDTO(String descripcionDTO) {
		this.descripcionDTO = descripcionDTO;
	}
	public Double getPrecioDTO() {
		return precioDTO;
	}
	public void setPrecioDTO(Double precioDTO) {
		this.precioDTO = precioDTO;
	}
	public Integer getStockDTO() {
		return stockDTO;
	}
	public void setStockDTO(Integer stockDTO) {
		this.stockDTO = stockDTO;
	}
	
}
