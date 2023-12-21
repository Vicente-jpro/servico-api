package com.prestacao.servicoapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.prestacao.servicoapi.enums.FormaPagamentoEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicoPagamentoDto {

    private Long id;
    private BigDecimal valorPago;
    private FormaPagamentoEnum formaPagamento;
    private ServicoPrestadoDto servicoPrestado;
    private UsuarioDto usuarioDto;
    private LocalDateTime dataPagamento;

}
