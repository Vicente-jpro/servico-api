package com.example.loja2023.securityjwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.example.loja2023.services.UsuarioService;

public class JwtAuthFilter extends OncePerRequestFilter {

	private JwtService jwtService;
	private UsuarioService usuarioService;

	public JwtAuthFilter(JwtService jwtService, UsuarioService usuarioService) {
		this.jwtService = jwtService;
		this.usuarioService = usuarioService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// String authorizationHeader = request.getHeader("Authorization");

		// if (authorizationHeader != null && authorizationHeader.startsWith("Bearer"))
		// {
		// String token = authorizationHeader.split(" ")[1];
		// boolean isValid = jwtService.tokenValido(token);

		// if (isValid) {
		// String loginUsuario = jwtService.obterLoginUsuario(token);
		// UserDetails userDetails = usuarioService.loadUserByUsername(loginUsuario);
		// UsernamePasswordAuthenticationToken user = new
		// UsernamePasswordAuthenticationToken(userDetails, null,
		// userDetails.getAuthorities());

		// user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		// SecurityContextHolder.getContext().setAuthentication(user);
		// }
		// }

		// filterChain.doFilter(request, response);
	}

}
