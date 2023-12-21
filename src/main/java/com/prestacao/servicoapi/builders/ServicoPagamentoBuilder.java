package com.prestacao.servicoapi.builders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.ServicoPagamentoDto;
import com.prestacao.servicoapi.models.ServicoPagamento;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServicoPagamentoBuilder {

    private final ServicoPrestadoBuilder servicoPrestadoBuilder;
    private final UsuarioBuilder usuarioBuilder;

    public ServicoPagamento toModel(ServicoPagamentoDto servicoPagamentoDto) {

        return ServicoPagamento.builder()
                .id(servicoPagamentoDto.getId())
                .valorPago(servicoPagamentoDto.getValorPago())
                .formaPagamento(servicoPagamentoDto.getFormaPagamento())
                .servicoPrestado(servicoPrestadoBuilder.toModel(servicoPagamentoDto.getServicoPrestado()))
                .dataPagamento(servicoPagamentoDto.getDataPagamento())
                .usuario(usuarioBuilder.toModel(servicoPagamentoDto.getUsuarioDto()))
                .build();
    }

    public ServicoPagamentoDto toDto(ServicoPagamento servicoPagamento) {

        return ServicoPagamentoDto.builder()
                .id(servicoPagamento.getId())
                .valorPago(servicoPagamento.getValorPago())
                .formaPagamento(servicoPagamento.getFormaPagamento())
                .servicoPrestado(servicoPrestadoBuilder.toDto(servicoPagamento.getServicoPrestado()))
                .dataPagamento(servicoPagamento.getDataPagamento())
                .usuarioDto(usuarioBuilder.toDto(servicoPagamento.getUsuario()))
                .build();
    }
}
