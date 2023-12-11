package com.prestacao.servicoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prestacao.servicoapi.models.ServicoPagamento;

public interface ServicoPagamentoRepository extends JpaRepository<ServicoPagamento, Long> {

}
