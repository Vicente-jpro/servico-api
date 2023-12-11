package com.prestacao.servicoapi.bulders;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.ServicoPagamentoDto;
import com.prestacao.servicoapi.models.ServicoPagamento;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServicoPagamentoBuilder {

    private final ServicoPrestadoBuilder servicoPrestadoBuilder;

    public ServicoPagamento toModel(ServicoPagamentoDto servicoPagamentoDto) {

        return ServicoPagamento.builder()
                .id(servicoPagamentoDto.getId())
                .valorPago(servicoPagamentoDto.getValorPago())
                .servicoPrestado(servicoPrestadoBuilder.toModel(servicoPagamentoDto.getServicoPrestado()))
                .dataPagamento(servicoPagamentoDto.getDataPagamento())
                .build();
    }

    public ServicoPagamentoDto toDto(ServicoPagamento servicoPagamento) {

        return ServicoPagamentoDto.builder()
                .id(servicoPagamento.getId())
                .valorPago(servicoPagamento.getValorPago())
                .servicoPrestado(servicoPrestadoBuilder.toDto(servicoPagamento.getServicoPrestado()))
                .dataPagamento(servicoPagamento.getDataPagamento())
                .build();
    }
}
