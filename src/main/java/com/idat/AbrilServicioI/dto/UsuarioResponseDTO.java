package com.idat.AbrilServicioI.dto;

public class UsuarioResponseDTO {

	private String token = "";

	
	public UsuarioResponseDTO(String token) {
		super();
		this.token = token;
	}

	public UsuarioResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
