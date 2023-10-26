package com.example.loja2023.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
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

}