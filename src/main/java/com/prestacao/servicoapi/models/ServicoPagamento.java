package com.prestacao.servicoapi.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.prestacao.servicoapi.enums.FormaPagamentoEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "servico_pagamentos")
public class ServicoPagamento {

    private Long id;
    private BigDecimal valorPago;
    private FormaPagamentoEnum formaPagamento;

}
