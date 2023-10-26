package com.example.loja2023.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loja2023.models.Cidade;
import com.example.loja2023.models.Provincia;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findAllByProvincia(Provincia provincia);
}
