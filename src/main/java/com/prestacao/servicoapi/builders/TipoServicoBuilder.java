package com.prestacao.servicoapi.builders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.TipoServicoDto;
import com.prestacao.servicoapi.models.TipoServico;

@Component
public class TipoServicoBuilder {

    public TipoServico toModel(TipoServicoDto tipoServicoDto) {
        return new TipoServico(
                tipoServicoDto.getId(), tipoServicoDto.getNomeServico(), tipoServicoDto.getPreco(), null);
    }

    public TipoServicoDto toDto(TipoServico tipoServico) {
        return TipoServicoDto
                .builder()
                .id(tipoServico.getId())
                .nomeServico(tipoServico.getNomeServico())
                .preco(tipoServico.getPreco())
                .build();
    }

}
