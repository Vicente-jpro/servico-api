package com.example.loja2023.securityjwt;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.loja2023.models.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	@Value("${security.jwt.expiracao}")
	private String expiracao;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;

	// Gerar token codificado
	public String gerarToken(Usuario usuario) {
		long minutoExpiracao = Long.valueOf(expiracao);
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(minutoExpiracao);
		Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
		Date data = Date.from(instant);
		return Jwts
				.builder()
				.setSubject(usuario.getUsername())
				.setExpiration(data)
				.signWith(SignatureAlgorithm.HS512, chaveAssinatura)
				.compact();

	}

	// Decodificar o token
	private Claims obterClaims(String token) throws ExpiredJwtException {
		return Jwts
				.parser()
				.setSigningKey(chaveAssinatura)
				.parseClaimsJws(token)
				.getBody();
	}

	public boolean tokenValido(String token) {
		try {
			Claims claims = obterClaims(token);
			Date dataExpiDate = claims.getExpiration();
			LocalDateTime data = dataExpiDate
					.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDateTime();
			return !LocalDateTime.now().isAfter(data);
		} catch (Exception e) {
			return false;
		}
	}

	public String obterLoginUsuario(String token) throws ExpiredJwtException {
		return (String) obterClaims(token).getSubject();
	}

	// public static void main(String[] args) {
	// ConfigurableApplicationContext context =
	// SpringApplication.run(VendasApplication.class);
	// JwtService service = context.getBean(JwtService.class);
	// Usuario usuario = new Usuario();
	// usuario.setUsername("vicente");
	// String token = service.gerarToken(usuario);
	// System.out.println(token);
	//
	// boolean isTokenValido = service.tokenValido(token);
	// System.out.println("O token está valido? "+isTokenValido);
	// System.out.println(service.obterLoginUsuario(token));
	// }

}
