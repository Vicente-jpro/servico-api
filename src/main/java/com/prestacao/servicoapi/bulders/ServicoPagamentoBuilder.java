package com.prestacao.servicoapi.bulders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.prestacao.servicoapi.dto.ServicoPagamentoDto;
import com.prestacao.servicoapi.enums.FormaPagamentoEnum;
import com.prestacao.servicoapi.models.ServicoPagamento;
import com.prestacao.servicoapi.models.ServicoPrestado;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServicoPagamentoBuilder {

    private final ServicoPrestadoBuilder servicoPrestadoBuilder;

    public ServicoPagamento toModel(ServicoPagamentoDto servicoPagamentoDto) {

        LocalDateTime dataPagamento = LocalDateTime.parse(servicoPagamentoDto.getDataPagamento());
        return ServicoPagamento.builder()
                .id(servicoPagamentoDto.getId())
                .valorPago(servicoPagamentoDto.getValorPago())
                .servicoPrestado(servicoPrestadoBuilder.toModel(servicoPagamentoDto.getServicoPrestado()))
                .dataPagamento(dataPagamento)
                .build();
    }

    public ServicoPagamentoDto toDto(ServicoPagamento servicoPagamento) {

        return ServicoPagamentoDto.builder()
                .id(servicoPagamento.getId())
                .valorPago(servicoPagamento.getValorPago())
                .servicoPrestado(servicoPrestadoBuilder.toDto(servicoPagamento.getServicoPrestado()))
                .dataPagamento(servicoPagamento.getDataPagamento().toString())
                .build();
    }
}
