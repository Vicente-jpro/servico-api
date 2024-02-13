package com.prestacao.servicoapi.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
    @JoinColumn(name = "servio_prestado_id")
    private ServicoPrestado servicoPrestado;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
