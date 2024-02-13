package com.prestacao.servicoapi.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "servico_prestados")
public class ServicoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicio")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "pagamento_parcela")
    private BigDecimal pagamentoParcela;

    @ManyToOne
    @JoinColumn(name = "tipo_servico_id")
    private TipoServico tipoServico;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
