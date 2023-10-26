package com.example.loja2023.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loja2023.models.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByUsername(String username);
	

	boolean existsByEmail(String email);

}
