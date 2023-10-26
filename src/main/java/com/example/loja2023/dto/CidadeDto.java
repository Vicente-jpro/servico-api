package com.example.loja2023.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.loja2023.models.Endereco;
import com.example.loja2023.models.Provincia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CidadeDto {

    private Long id;
    private String nomeCidade;
    private ProvinciaDto provincia;
    private List<EnderecoDto> enderecos;
}
