package com.prestacao.servicoapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prestacao.servicoapi.models.Cidade;
import com.prestacao.servicoapi.models.Provincia;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findAllByProvincia(Provincia provincia);
}
