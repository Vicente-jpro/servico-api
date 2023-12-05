package com.prestacao.servicoapi.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_servicos")
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_servico", unique = true, length = 70)
    private String nomeServico;

    @Column(name = "preco")
    private BigDecimal preco;

    @OneToMany(mappedBy = "tipoServico", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ServicoPrestado> servicoPrestados;

}
