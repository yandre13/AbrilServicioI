package com.idat.AbrilServicioI.seguridad;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;


@Component
public class TokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserDetailService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestHeader = request.getHeader("Authorization");
		
		String token = null;
		String username = null;
		
		if(requestHeader != null && requestHeader.startsWith("Bearer ")) {
			token = requestHeader.substring(7);
			try {
				username = util.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				System.out.println("Argumento del token inválido");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT expirado");
			}
		}else {
			logger.warn("JWT no contiene la palabra Bearer");
			logger.warn(requestHeader);
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails details = this.service.loadUserByUsername(username);
			
			if(util.validateToken(token, details)) {
				UsernamePasswordAuthenticationToken usernameToken = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
				usernameToken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernameToken);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
