package com.prestacao.servicoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prestacao.servicoapi.models.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepositoy extends JpaRepository<UsuarioPerfil, Long> {

}
