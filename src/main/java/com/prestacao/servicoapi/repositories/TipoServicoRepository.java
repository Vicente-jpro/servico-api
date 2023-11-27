package com.prestacao.servicoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prestacao.servicoapi.models.TipoServico;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {

}
