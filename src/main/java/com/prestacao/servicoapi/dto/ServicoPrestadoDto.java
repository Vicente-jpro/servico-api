package com.prestacao.servicoapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicoPrestadoDto {

    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime dataCadastro;
    private BigDecimal pagamentoParcela;
    private TipoServicoDto tipoServico;
    private ClienteDto cliente;

}
