package com.prestacao.servicoapi.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoServicoDto {
    private Long id;
    private String nomeServico;
    private BigDecimal preco;
}
