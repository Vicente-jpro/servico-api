package com.example.loja2023.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loja2023.models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
