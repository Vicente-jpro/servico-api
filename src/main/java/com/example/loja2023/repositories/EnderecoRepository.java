package com.example.loja2023.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loja2023.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
