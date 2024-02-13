package com.prestacao.servicoapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idUsuario;

	@Column(name = "username")
	@NotBlank(message = "Nome de usuario não pode estar em branco.")
	private String username;

	@Column(name = "email", unique = true)
	@NotBlank(message = "Email não pode estar em branco.")
	private String email;

	@Column(name = "passwrd")
	@NotBlank(message = "Campo palavra pass não pode estar vazio")
	private String passwrd;

	@OneToMany(mappedBy = "usuario")
	private List<UsuarioPerfil> usuarioPerfils;

	@OneToMany(mappedBy = "usuario")
	private List<Cliente> clientes;

	@OneToMany(mappedBy = "usuario")
	private List<ServicoPagamento> servicoPagamentos;

}
