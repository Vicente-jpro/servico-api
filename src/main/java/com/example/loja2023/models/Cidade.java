package com.example.loja2023.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "cidades")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cidade", length = 20)
    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    @OneToMany(mappedBy = "cidade")
    private List<Endereco> enderecos;
}
