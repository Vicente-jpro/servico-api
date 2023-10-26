package com.example.loja2023.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.loja2023.models.Cidade;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProvinciaDto {

    private Long id;
    private String nomeProvincia;
    private List<CidadeDto> cidades;
}
