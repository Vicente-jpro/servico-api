package com.prestacao.servicoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prestacao.servicoapi.models.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

}
