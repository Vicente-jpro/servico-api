package com.prestacao.servicoapi.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.prestacao.servicoapi.models.Endereco;
import com.prestacao.servicoapi.models.Provincia;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CidadeDto {

    private Long id;
    private String nomeCidade;
    private ProvinciaDto provincia;
    // private List<EnderecoDto> enderecos;
}
