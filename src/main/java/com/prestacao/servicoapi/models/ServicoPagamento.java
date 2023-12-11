package com.prestacao.servicoapi.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.prestacao.servicoapi.enums.FormaPagamentoEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "servico_pagamentos")
public class ServicoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_pago", precision = 20, scale = 2)
    private BigDecimal valorPago;

    @Enumerated(EnumType.STRING)
    private FormaPagamentoEnum formaPagamento;

    @ManyToOne
    @JoinColumn(name = "servio_prestado")
    private ServicoPrestado servicoPrestado;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

}
