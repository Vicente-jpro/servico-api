package com.prestacao.servicoapi.bulders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.ServicoPrestadoDto;
import com.prestacao.servicoapi.models.ServicoPrestado;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServicoPrestadoBuilder {

    private final TipoServicoBuilder tipoServicoBuilder;
    private final ClienteBuilder clienteBuilder;

    public ServicoPrestado toModel(ServicoPrestadoDto servicoPrestadoDto) {
        return new ServicoPrestado(
                servicoPrestadoDto.getId(),
                servicoPrestadoDto.getDataInicio(),
                servicoPrestadoDto.getDataFim(),
                servicoPrestadoDto.getDataCadastro(),
                servicoPrestadoDto.getPagamentoParcela(),
                tipoServicoBuilder.toModel(servicoPrestadoDto.getTipoServico()),
                clienteBuilder.toModel(servicoPrestadoDto.getCliente()));
    }

    public ServicoPrestadoDto toDto(ServicoPrestado servicoPrestado) {
        return ServicoPrestadoDto.builder()
                .id(servicoPrestado.getId())
                .dataCadastro(servicoPrestado.getDataCadastro())
                .dataInicio(servicoPrestado.getDataInicio())
                .dataFim(servicoPrestado.getDataFim())
                .dataCadastro(servicoPrestado.getDataCadastro())
                .pagamentoParcela(servicoPrestado.getPagamentoParcela())
                .tipoServico(tipoServicoBuilder.toDto(servicoPrestado.getTipoServico()))
                .cliente(clienteBuilder.toDto(servicoPrestado.getCliente()))
                .build();
    }
}
