package com.prestacao.servicoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prestacao.servicoapi.models.ServicoPrestado;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long> {

}
