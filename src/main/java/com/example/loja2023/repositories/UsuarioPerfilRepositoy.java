package com.example.loja2023.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loja2023.models.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepositoy extends JpaRepository<UsuarioPerfil, Long> {

}
